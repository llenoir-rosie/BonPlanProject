package ProjetBonPlan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    @PostMapping(path="/activity/new", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void createNewActivity(@RequestBody activity activite){
        
        String act_name = activite.getName();
        String act_description = activite.getDescription();
        String act_image = activite.getImage();

        try{
            activityService.createNewActivity(act_name, act_image, act_description);
        }catch (Exception e){
            System.out.println("Cette activite a deja ete ajoutee");
        }
    }

    //Delete the activity, return false if user doesn't have the rights
    @DeleteMapping(path="activity/delete", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void DeleteActivity(@RequestBody String name){
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