package main.java.routes;
import main.java.api.MainApi;

import static spark.Spark.*;

public class Routes {

public Routes(){
    MainApi api = new MainApi();

    get("/", (req, res) -> {
        res.type("application/json");
//        {\"message\":\"Custom 404\"}
        return "{\"status\":\"success\"}";
//        return res.raw();
    });

    post("/login", (req, res) -> {
        String username = req.queryParams("username");
        String password = req.queryParams("password");
        api.login(username,password);
        res.redirect("/");
        return null;
    });

    post("/signup", (req, res) -> {

        res.redirect("/");
        return null;
    });

    post("/report", (req, res) -> {

        res.redirect("/");
        return null;
    });






}
}
