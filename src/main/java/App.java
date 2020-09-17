import routes.Routes;

import static spark.Spark.port;
import static spark.Spark.staticFiles;


public class App {

    public static void main(String[] args) throws Exception {
//        Boolean localhost = false;
//        if (localhost) {
//            String projectDir = System.getProperty("user.dir");
//            String staticDir = "/src/main/resources/public";
//            staticFiles.externalLocation(projectDir + staticDir);
//        } else {
//            staticFiles.location("/public");
//        }
        staticFiles.location("/public"); // Static files
//        Spark.staticFileLocation("/public");
        port(getHerokuAssignedPort());
//        connection();
        new Routes();

    }

//    public static Connection connection() throws Exception {
//        final String DATABASE_URL = "jdbc:h2:mem:db1";
//        Class.forName("org.h2.Driver");
//        Connection conn = DriverManager.getConnection(DATABASE_URL, "sa", "");
//        String sql = "create table GREET (\n" +
//                "id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
//                "name varchar(40),\n" +
//                "count int\n" + ");";
//        PreparedStatement createTable = conn.prepareStatement(sql);
//        createTable.execute();
//        return conn;
//    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}