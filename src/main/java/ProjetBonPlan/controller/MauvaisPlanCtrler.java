package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import ProjetBonPlan.model.mauvaisplan;
import ProjetBonPlan.service.MauvaisPlanService;


@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MauvaisPlanCtrler {

    @Autowired //if multiple constructor
    private MauvaisPlanService mauvaisplanService;

    //@return All Mauvaiss Plans (mauvaisplan.java) that concern an activity (activity.java) of a city (cities.java)
    @GetMapping(path= "/{city}/{activity}/mauvaisplan")
    public ResponseEntity<List<mauvaisplan>> getMauvaisPlan(@PathVariable("city") String city, @PathVariable("activity") String activity) {
        List<mauvaisplan> allBP = mauvaisplanService.getMauvaisPlan(city, activity);
        return new ResponseEntity<>(allBP, HttpStatus.OK);
        }
    
    //Create a new Mauvais Plan (mauvaisplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    //A refaire avec un post de l'objet et pas de ses variables séparemments
    @PostMapping(path= "/{city}/{activity}/newmauvaisplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void postMauvaisPlan(@RequestBody mauvaisplan newMauvaisPlan) {
        // String nameBP="newBP";
        // String adressCity="25 rue du beau";
        // String activityType="foot";
        // String nameCity = "Grenoble"; 
        mauvaisplanService.createNewMauvaisPlan(newMauvaisPlan);
    }

    //Delete a Mauvais plan (mauvaisplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    @DeleteMapping(path= "/{city}/{activity}/{name}/deletemauvaisplan")
    public void deleteMauvaisPlan(@PathVariable("name") String name) {
        mauvaisplanService.deleteThisMauvaisPlan(name);
    }

    //Update a Mauvais plan (mauvaisplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    @PutMapping(path= "/{city}/{activity}/updatemauvaisplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateMauvaisPlan(@RequestBody mauvaisplan upMauvaisPlan) {
        mauvaisplanService.updateThisMauvaisPlan(upMauvaisPlan);
    }

    @GetMapping(path="/{city}/{activites}/countmauvaisplan", 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer count(@PathVariable ("city") String city, @PathVariable ("activites") String activites){
        return mauvaisplanService.count(city, activites);
    }

    //Get All MauvaisPlan of the user
    @GetMapping(path="/{username}/AllMauvaisPlan")
    public ResponseEntity<List<mauvaisplan>> getUserMauvaisPlan(@PathVariable("username") String username) {
        List<mauvaisplan> allMP = mauvaisplanService.getUserMauvaisPlan(username);
        return new ResponseEntity<>(allMP, HttpStatus.OK);
        }
    
}
