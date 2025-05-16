package ticket_booking.entities;

import javax.swing.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainName;
    private String source;
    private String destination;
    private Date dateTime;
    private List<List<Boolean>> seats;
    private List<String> stations;
    private Map<String,Date> schedule;
}
