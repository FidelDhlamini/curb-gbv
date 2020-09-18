import Config.DBConfig;
import routes.Routes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static spark.Spark.port;
import static spark.Spark.staticFiles;


public class App {

    public static void main(String[] args) throws Exception {

        staticFiles.location("/public"); // Static files
        port(getHerokuAssignedPort());
        connection();
        new Routes();

    }

    public static Connection connection() throws Exception {
        DBConfig dbConfig = new DBConfig();
        final String DATABASE_URL = "jdbc:postgresql://[::1]:5432/postgres";
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(dbConfig.CLOUD_DATABASE_URL, dbConfig.User, dbConfig.Password);
        String sql = "CREATE TABLE reportedCases (\n" +
                "\tid serial PRIMARY KEY,\n" +
                "\tname TEXT,\n" +
                "\tcontact TEXT,\n" +
                "\tlocation TEXT,\n" +
                "\tdetails TEXT NOT NULL,\n" +
                "\tcontactMe TEXT,\n" +
                "\tresolved BOOLEAN\n" +
                ");\n";
        try {
            PreparedStatement createTable = conn.prepareStatement(sql);
            createTable.execute();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            return conn;
        }
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}