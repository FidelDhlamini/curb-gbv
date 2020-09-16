package raiders;
import java.util.List;

import org.jdbi.v3.core.Jdbi;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
    static Jdbi getJdbiDatabaseConnection() throws URISyntaxException, SQLException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        String database_url = processBuilder.environment().get("imbokodo");
        if (database_url != null) {

            URI uri = new URI(database_url);
            String[] hostParts = uri.getUserInfo().split(":");
            String username = hostParts[0];
            String password = hostParts[1];
            String host = uri.getHost();

            int port = uri.getPort();

            String path = uri.getPath();
            String url = String.format("jdbc:postgresql://localhost/imbokodo?username=justin&password=Justine123", host, port, path);

            return Jdbi.create(url, username, password);
        }

        return Jdbi.create("jdbc:postgresql://localhost/imbokodo?username=justin&password=Justine123");

    }

    public static void main(String[] args) {
        try{
            port(getHerokuAssignedPort());
            Jdbi jdbi = getJdbiDatabaseConnection();

            get("/", (req, res) -> {

                List<Users> users = jdbi.withHandle((h) -> {
                    List<Users> thePeople = h.createQuery("select first_name, last_name, email from users")
                            .mapToBean(Users.class)
                            .list();
                    return thePeople;

                });

                Map<String, Object> map = new HashMap<>();
                map.put("Users", users);



                return new ModelAndView(map, "index.handlebars");

            }, new HandlebarsTemplateEngine());
            post("/users", (req, res) -> {

                String firstName = req.queryParams("firstName");
                String lastName = req.queryParams("lastName");
                String email = req.queryParams("email");

                jdbi.useHandle(h -> h.execute("insert into users (first_name, last_name, email) values (?, ?, ?)",
                        firstName,
                        lastName,
                        email));

                res.redirect("/");
                return "";
            });
            post("/admin", (req, res) -> {

                String username = req.queryParams("username");
                String password = req.queryParams("password");
                jdbi.useHandle(h -> h.execute("SELECT * FROM admin WHERE name ="  + username + " AND password = " + password + "",
                        username,
                        password));
                return null;


            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        }


    }

