package services;
import java.util.HashMap;
import java.util.Map;


public class Report {


    public Map<String, Object> takeUserDetails(String name, String contact, String location, String details, String victimState) {
        Map<String, Object> user = new HashMap<>();
        user.put("contact", contact);
        user.put("name", name);
        user.put("location", location);
        user.put("details", details);
        user.put("victimState", victimState);

        return user;
    }
}


