package services;
import java.util.HashMap;
import java.util.Map;


public class Report {
    DBQueries dbQueries = new DBQueries();
    public Map<String, Object> takeUserDetails(String name, String contact, String location, String details, String contactMe) {
        Map<String, Object> report = new HashMap<>();
        report.put("contact", contact);
        report.put("name", name);
        report.put("location", location);
        report.put("details", details);
        report.put("contactMe", contactMe);
        dbQueries.storeInDatabase(report);
        return report;
    }
}


