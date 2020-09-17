package api;

import services.Report;

public class MainApi {

    public void login(String username, String password){

    }

    public void reportCase(String contact, String name, String location, String details){
        Report report = new Report();
        report.takeUserDetails(name, contact, location, details, "");
    }


}
