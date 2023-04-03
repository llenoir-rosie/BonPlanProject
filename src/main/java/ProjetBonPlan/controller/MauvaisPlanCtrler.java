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

    //@return All Mauvaiss Plans (mauvaisplan.java) that concern an activity (activites.java) of a city (cities.java)
    @GetMapping(path= "/{city}/{activites}/mauvaisplan")
    public ResponseEntity<List<mauvaisplan>> getMauvaisPlan(@PathVariable("city") String city, @PathVariable("activites") String activity) {
        List<mauvaisplan> allBP = mauvaisplanService.getMauvaisPlan(city, activity);
        return new ResponseEntity<>(allBP, HttpStatus.OK);
        }
    
    //Create a new Mauvais Plan (mauvaisplan.java) embedded in a particular activity (activites.java) of a city (cities.java)
    //A refaire avec un post de l'objet et pas de ses variables séparemments
    @PostMapping(path= "/{city}/{activites}/newmauvaisplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void postMauvaisPlan(@RequestBody mauvaisplan newMauvaisPlan) {
        // String nameBP="newBP";
        // String adressCity="25 rue du beau";
        // String activityType="foot";
        // String nameCity = "Grenoble"; 
        mauvaisplanService.createNewMauvaisPlan(newMauvaisPlan);
    }

    //Delete a Mauvais plan (mauvaisplan.java) embedded in a particular activity (activites.java) of a city (cities.java)
    @DeleteMapping(path= "/{city}/{activites}/{name}")
    public void deleteMauvaisPlan(@PathVariable("name") String name) {
        mauvaisplanService.deleteThisMauvaisPlan(name);
    }

    //Update a Mauvais plan (mauvaisplan.java) embedded in a particular activity (activites.java) of a city (cities.java)
    @PutMapping(path= "/{city}/{activites}/updatemauvaisplan")
    public void updateMauvaisPlan(mauvaisplan upMauvaisPlan) {
        mauvaisplanService.updateThisMauvaisPlan(upMauvaisPlan);
    }
    
}
