package ticket_booking.entities;

import java.util.List;

public class User {
private String userName;
private String password;
private String hasehedPassword;
private List<Tickets> ticketsBooked;
private String userId;

public User(String userName,String password,String hasehedPassword,List<Tickets> ticketsBooked,String userId)
{
    this.userName=userName;
    this.password=password;
    this.hasehedPassword=hasehedPassword;
    this.ticketsBooked=ticketsBooked;
    this.userId=userId;
}
public User(){}
private String getUserName(){
    return userName;
    }
private String getPassword()
{
    return password;

}
private String getHasehedPassword(){
    return hasehedPassword;
}
private List<Tickets> getTicketsBooked(){
    return ticketsBooked;
}
private void printTickets()
{
    for(int i=0;i<ticketsBooked.size();i++)
    {
        System.out.println(ticketsBooked.get(i).getTicketInfo());
    }
}
private String getUserId(){
    return userId;
}
private void setUserName(String name){
    this.userName=name;
}
    public void setHashedPassword(String hashedPassword) {
        this.hasehedPassword = hashedPassword;
    }
    public void setTicketsBooked(List<Tickets> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setPassword(String pass)
    {
        this.password = pass;
    }

}
