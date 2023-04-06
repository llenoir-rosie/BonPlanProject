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

import ProjetBonPlan.model.activites;
import ProjetBonPlan.service.ActivitesService;


@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of activities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ActivitesCtrler {

    @Autowired //if multiple constructor
    private ActivitesService activitesService;

    //If HTTP request equals getAllCities promising a response of List of city in localhost://8080/activites
    //@return All activity (activites.java)
    @GetMapping(path= "/activites")
    public List<activites> getAllActivites() {
        return activitesService.getAllActivites();
        }

    //@return an activity (acitivities.java) selected by its props activity.name
    @GetMapping(path="activites/{nom}")
    public activites getactivitesByNom(@PathVariable("nom") String nom){
        return activitesService.getactivitesByNom(nom);
    }

    //@return All Activities of a city (name of the city in the path)
    @GetMapping(path="/{city}/activites")
    public List<activites> getActivitiesByCity(@PathVariable("city") String city){
        return activitesService.getActivitiesByCity(city);
    }

    //Create a new activity of type activity, return false if name already exist
    @PostMapping(path="/activite/new", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void createNewActivity(@RequestBody activites activite){
        
        String act_name = activite.getName();
        String act_description = activite.getDescription();
        String act_image = activite.getImage();

        try{
            activitesService.createNewActivity(act_name, act_image, act_description);
        }catch (Exception e){
            System.out.println("Cette activite a deja ete ajoutee");
        }
    }

    //Delete the activity, return false if user doesn't have the rights
    @DeleteMapping(path="activite/delete", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void DeleteActivity(@RequestBody String name){
        try{
            activitesService.DeleteActivity(name);
        }catch (Exception e){
            System.out.println("l activite ne peut pas etre supprimee");//afficher pas le message?
        }
    }
    //Update an Activity (activites.java), return false if the activity can't be updated
    @PutMapping(path="/activite/update")
    public void updateActivity(activites act) {
        try{
            activitesService.updateActivity(act);
        } catch (Exception e) {
            System.out.println("l activite ne peut pas etre mise à jour");
        }
    }



}