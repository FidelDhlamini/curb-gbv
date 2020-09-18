package api;

import services.DBQueries;
import services.Report;

import java.sql.ResultSet;

public class MainApi {

    public void reportCase(String contact, String name, String location, String details, String contactMe){
        Report report = new Report();
        report.takeUserDetails(name, contact, location, details, contactMe);
    }

    public String getAllCoordinates(){
        DBQueries dbQueries = new DBQueries();
        return dbQueries.getAllCoordinates();
    }

    public String getAllData(){
        DBQueries dbQueries = new DBQueries();
        return dbQueries.getAllDataFromDB();
    }

    public int getTotalReported(){
        DBQueries dbQueries = new DBQueries();
        return dbQueries.getTotalReported();
    }


}
