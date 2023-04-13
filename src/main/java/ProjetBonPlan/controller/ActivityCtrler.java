package ProjetBonPlan.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.io.* ;

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
    public void createNewActivity(@RequestBody activity activite) throws IOException{
        String act_name = activite.getName();
        String act_description = activite.getDescription();
        String act_image = activite.getImage(); //nom de l image stockée dans Telechargements

        // String src = "C:\\Users\\cfavre\\Downloads" + act_image;
        // System.out.println(src);
        // String dest = "C:\\Users\\cfavre\\BonPlanFront\\src\\assets\\img" + act_image;
        // System.out.println(dest);
        // Files.move(Paths.get(src), Paths.get(dest));

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
    @PutMapping(path="/activity/update",consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateActivity(@RequestBody activity activite) throws IOException, InterruptedException {
        String act_name = activite.getName();
        //String act_description = activite.getDescription();
        String act_image = activite.getImage(); //nom de l image stockée dans Telechargements

        if (act_image != ""){
            String src = System.getProperty("user.home") + "\\" + act_image;
           // String src = "C:/Users/cfavre/Downloads/" + act_image;
            String dest = "C:/Users/cfavre/BonPlanFront/src/assets/img/" + act_image;
            
            System.out.println(src);
            
            //System.out.println(System.getProperty("user.home"));

            File file1 = new File(src);
            System.out.println(file1.exists());
            File file2 = new File(dest);

            while (!file1.exists()){
                System.out.println("loading file ...");
                TimeUnit.SECONDS.sleep(2); //attendre si le telechargement est long
            }
            
            if (!file2.exists()){ //si l image n existe pas dans le dossier image /assets/img, le deplacer
                Files.move(Paths.get(src), Paths.get(dest));
            }
            
            String UpdatePathImage = "../assets/img/" + act_image;
            activite.setImage(UpdatePathImage);

            Files.delete(Paths.get(src)); //suppr fichier saved by file-saver dans downloads
        }else{
            activite.setImage(getActivityByNom(act_name).getImage());
        }
        
        try{
            activityService.updateActivity(activite);
        } catch (Exception e) {
            System.out.println("l activite ne peut pas etre mise à jour");
        }

        
    }
}