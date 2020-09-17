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
        res.redirect("/resourcePortal.html");
        return null;
    });

    get("/report", (req,res) -> {
        res.redirect("/report.html");
        return null;
    });

    get("/reported-data", (req,res) -> {
        return null;
    });

    post("/report", (req,res) -> {

        String contact = req.queryParams("contact");
        String name = req.queryParams("name");
        String location = req.queryParams("location");
        String details = req.queryParams("details");
        api.reportCase(contact, name, location, details);
        res.redirect("/resource");
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







}
}
