package main.java.services.imbokodo;
import java.util.ArrayList;

public class Report {

    private String name ;
    private String email;
    private String location;
    private String victimName;
    private String victimState;
    ArrayList <String> urgent = new ArrayList<String>();
    ArrayList <String> fine = new ArrayList<String>();

    public void takeUserDetails(String name,String email,String location){
        this.name = name;
        this.email = email;
        this.location = location;
    }
   public void takeVictimDetails(String victimName,String victimState){
        if(victimState.equals("Severely Injured")){
            urgent.add(victimName);
        }
        if(victimState.equals("In Good Health")){
            fine.add(victimName);
        }

   }



}
