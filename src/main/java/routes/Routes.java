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
        return api.getAllData();
    });

    get("/total-count", (req,res) -> {
        return api.getTotalReported();
    });

    get("/get-coordinates", (req,res) -> {
        res.type("application/json");
        return api.getAllCoordinates();
    });

    post("/report", (req,res) -> {

        String contact = req.queryParams("contact");
        String name = req.queryParams("name");
        String location = req.queryParams("location");
        String details = req.queryParams("details");
        String contactMe = req.queryParams("contactMe");
        if(contactMe == null) contactMe = "no";
        api.reportCase(contact, name, location, details, contactMe);
        res.redirect("/resource");
        return null;
    });







}
}
