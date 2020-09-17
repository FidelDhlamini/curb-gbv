package api;

import services.DBQueries;
import services.Report;

public class MainApi {

    public void reportCase(String contact, String name, String location, String details, String contactMe){
        Report report = new Report();
        report.takeUserDetails(name, contact, location, details, contactMe);
    }

    public String getAllCoordinates(){
        DBQueries dbQueries = new DBQueries();
        return dbQueries.getAllCoordinates();
    }


}
