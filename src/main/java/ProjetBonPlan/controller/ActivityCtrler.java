package ProjetBonPlan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import ProjetBonPlan.model.activity;
import ProjetBonPlan.service.ActivityService;


@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of activities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ActivityCtrler {

    @Autowired //if multiple constructor
    private ActivityService activityService;

    //If HTTP request equals getAllCities promising a response of List of city in localhost://8080/activity
    //@return All activity (activity.java)
    @GetMapping(path= "/activities")
    public List<activity> getAllActivity() {
        return activityService.getAllActivity();
        }

    //@return an activity (acitivities.java) selected by its props activity.name
    @GetMapping(path="activity/{nom}")
    public activity getActivityByNom(@PathVariable("nom") String nom){
        return activityService.getActivityByNom(nom);
    }

    //@return All Activities of a city (name of the city in the path)
    @GetMapping(path="/{city}/activites")
    public List<activity> getActivitiesByCity(@PathVariable("city") String city){
        return activityService.getActivitiesByCity(city);
    }

    //Create a new activity of type activity, return false if name already exist
    @PostMapping(path="/activity/new")
    public void createNewActivity(String name, String image, String description, String type){
        String act_name = "basket";
        String act_description = "le basket c'est cool";
        String act_image = "../assets/img/basket.jfif";
        String act_type = "sport";
        try{
            activityService.createNewActivity(act_name, act_image, act_description, act_type);
        }catch (Exception e){
            System.out.println("Cette activite a deja ete ajoutee");
        }
    }

    //Delete the activity, return false if user doesn't have the rights
    @DeleteMapping(path="activity/delete")
    public void DeleteActivity(String name){
        name = "basket";
        try{
            activityService.DeleteActivity(name);
        }catch (Exception e){
            System.out.println("l activite ne peut pas etre supprimee");//afficher pas le message?
        }
    }

    //Update an Activity (activity.java), return false if the activity can't be updated
    @PutMapping(path="/activity/update")
    public void updateActivity(activity act) {
        try{
            activityService.updateActivity(act);
        } catch (Exception e) {
            System.out.println("l activite ne peut pas etre mise à jour");
        }
    }



}