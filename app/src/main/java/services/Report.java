package main.java.services;
import java.util.HashMap;
import java.util.Map;


public class Report {


    public Map<String, Object> takeUserDetails(String name, String email, String location, String details, String victimState) {
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("name", name);
        user.put("location", location);
        user.put("details", details);
        user.put("victimState", victimState);

        return user;
    }
}


