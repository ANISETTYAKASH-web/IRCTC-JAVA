package ticket_booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket_booking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {
    private static final String trainpath = "../localDB/trains.json";
    public List<Train> trainList;
    private Train train;
    ObjectMapper objectMapper = new ObjectMapper();
    public TrainService() throws IOException
    {
        File trainfile = new File(trainpath);
        trainList = objectMapper.readValue(trainfile, new TypeReference<List<Train>>() {});
    }
    public List<Train> searchTrains(String source,String destination)
    {
        return trainList.stream().filter(train1->validTrain(train1,source,destination)).collect(Collectors.toList());

    }
    public Boolean validTrain(Train train,String source,String destination)
    {
        List<String> order = train.getStations();
        int sourceIndex = order.indexOf(source.toLowerCase());
        int destinationIndex = order.indexOf(destination.toLowerCase());
        return sourceIndex!=1&&destinationIndex!=-1&&destinationIndex>sourceIndex;
    }
    public void addTrain(Train newtrain)
    {
        Optional<Train> found= trainList.stream().filter(train1 -> train1.getTrainId().equalsIgnoreCase(newtrain.getTrainId())).findFirst();
        if(found.isPresent()) updateTrain(newtrain);
        else {
            trainList.add(newtrain);
            savetraintofile(newtrain);
        }
    }
    public void updateTrain(Train train)
    {
        OptionalInt index;
        index = IntStream.range(0,trainList.size()).filter(i->trainList.get(i).getTrainId().equalsIgnoreCase(train.getTrainId())).findFirst();
        if(index.isPresent())
        {
            trainList.set(index.getAsInt(),train);
            savetraintofile(train);
        }
        else addTrain(train);


    }
    public void savetraintofile(Train train)
    {
        trainList.add(train);
        try {
            objectMapper.writeValue(new File(trainpath), trainList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
