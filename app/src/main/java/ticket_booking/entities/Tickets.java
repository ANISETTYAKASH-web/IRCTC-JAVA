package ticket_booking.entities;

import java.util.Date;

public class Tickets {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private String dateTime;
    private Train train;

    public Tickets(String ticketId,String userId,String source,String destination,String dateTime,Train train)
    {
        this.ticketId=ticketId;
        this.dateTime=dateTime;
        this.userId=userId;
        this.destination=destination;
        this.train=train;
        this.source=source;
    }
    public String getTicketId(){
        return ticketId;
    }

    public void setTicketId(String ticketId){
        this.ticketId = ticketId;
    }

    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source = source;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public String getDateOfTravel(){
        return dateTime;
    }

    public void setDateOfTravel(String dateOfTravel){
        this.dateTime = dateOfTravel;
    }

    public Train getTrain(){
        return train;
    }

    public void setTrain(Train train){
        this.train = train;
    }
    public String getTicketInfo()
    {
        return String.format("ticketId: %s belongs to %s going from %s to %s on %s",ticketId,userId,source,destination,dateTime);
    }
}
