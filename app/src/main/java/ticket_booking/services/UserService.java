package ticket_booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket_booking.entities.Train;
import ticket_booking.entities.User;
import util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserService {
    private User user;
    private static final String user_path = "../localDB/user.json";
    private List<User> usersList;
    ObjectMapper objectMapper = new ObjectMapper();
    public UserService(User user1) throws IOException
    {
        this.user=user1;
        loadUsersFromFile();

    }
    public UserService() throws IOException
    {
        loadUsersFromFile();
    }
    private void loadUsersFromFile() throws IOException
    {
        File users = new File(user_path);
        usersList = objectMapper.readValue(users, new TypeReference<List<User>>() {
        });
    }
    public Boolean loginUser()
    {

        Optional<User> foundUser = usersList.stream().filter(user1 -> user.getUserName().equals(user1.getUserName())&& UserServiceUtil.checkPassword(user.getPassword(),user1.getHasehedPassword())).findFirst();
        return foundUser.isPresent();
    }
    public Boolean signUp(User user)
    {
        try {
            usersList.add(user);
             SaveUserToFile(user);
             return Boolean.TRUE;
        }
        catch (IOException ex) {
            return Boolean.FALSE;
        }
    }
    private void SaveUserToFile(User user) throws IOException
    {
        File usersFile = new File(user_path);
        objectMapper.writeValue(usersFile,usersList);
    }
    public void fetchBookings()
    {
        Optional<User> foundUser = usersList.stream().filter(user1 -> user.getUserName().equals(user1.getUserName())&& UserServiceUtil.checkPassword(user.getPassword(),user1.getHasehedPassword())).findFirst();
        if(foundUser.isPresent()) foundUser.get().printTickets();
    }
    public List<Train> getTrains(String source,String destination)
    {
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean bookSeat(Train train,int row,int seat)
    {
            Train trains = new Train();
            List<List<Integer>> seats = trains.getSeats();
            if(row>=0&&row<=seats.size()&&seat>=0&&seat<=seats.get(0).size())
            {
                if(seats.get(row).get(seat)==0)
                {
                    seats.get(row).set(seat,1);
                    train.setSeats(seats);
                    return Boolean.TRUE;
                }
                else return Boolean.FALSE;
            }
            else return Boolean.FALSE;

    }




}
