package routes;
import api.MainApi;

import static spark.Spark.*;

public class Routes {

public Routes(){

    MainApi api = new MainApi();

    get("/test", (req, res) -> {
        res.type("application/json");
//        {\"message\":\"Custom 404\"}
        return "{\"status\":\"success\"}";
//        res.redirect("index.html");
//        return null;
//        return res.raw();
    });

    get("/resource", (req,res) -> {
//        res.header("Content-Type", "text/html; charset=UTF-8");
//        res.type("text/html");
        res.redirect("/resourcePortal.html");
//        res.getClass().
        return null;
    });

    get("/report", (req,res) -> {
//        res.header("Content-Type", "text/html; charset=UTF-8");
//        res.type("text/html");
        res.redirect("/report.html");
//        res.getClass().
        return null;
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
