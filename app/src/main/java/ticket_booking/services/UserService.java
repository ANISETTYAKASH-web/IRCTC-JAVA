package ticket_booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket_booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserService {
    private User user;
    private static final String user_path = "../localDB/user.json";
    private List<User> usersList;
    ObjectMapper objectMapper = new ObjectMapper();
    public UserService(User user1) throws IOException
    {
        this.user=user1;
        File users = new File(user_path);
        usersList = objectMapper.readValue(user_path, new TypeReference<List<User>>() {
        });

    }


}
