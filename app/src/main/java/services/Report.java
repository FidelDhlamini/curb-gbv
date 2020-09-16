package main.java.services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Report {

    public void takeUserDetails(String name,String email,String location,String details,String victimState){
        Map<String,Object> user = new HashMap<>();
        user.put("email",email);
        user.put("name",name);
        user.put("location",location);
        user.put("details",details);
        user.put("victimState",victimState);

    }




}
