package services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBQueries {

    public static Connection getConnection() throws Exception {
        final String DATABASE_URL = "jdbc:postgresql://[::1]:5432/postgres";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(DATABASE_URL, "postgres", "pg123");
        return conn;
    };

    public void storeInDatabase(Map<String, Object> report){
        try {
            Connection conn = getConnection();
            final String INSERT_REPORT = "insert into reportedCases (contact, name, location, details, contactMe) values (?, ?, ?, ?, ?)";
            PreparedStatement insertReport = conn.prepareStatement(INSERT_REPORT);

            insertReport.setString(1, (String) report.get("contact"));
            insertReport.setString(2, (String) report.get("name"));
            insertReport.setString(3, (String) report.get("location"));
            insertReport.setString(4, (String) report.get("details"));
            insertReport.setString(5, (String) report.get("contactMe"));
            insertReport.execute();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public String getAllCoordinates(){
        try {
            Connection conn = getConnection();
            final String ALL_REPORTS = "select * from reportedCases";
            PreparedStatement getReports = conn.prepareStatement(ALL_REPORTS);
            getReports.execute();
            ResultSet rs = getReports.executeQuery();
            List<String> allCoords = new ArrayList<>();
            while(rs.next()) {
                allCoords.add(rs.getString("location"));
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(allCoords);

            //Print JSON output
//            System.out.println(json);
            return json;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }




}
