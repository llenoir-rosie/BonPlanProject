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


import ProjetBonPlan.model.bonplan;
import ProjetBonPlan.service.BonPlanService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BonPlanCtrler {

    @Autowired //if multiple constructor
    private BonPlanService bonplanService;

    //@return All Bons Plans (bonplan.java) that concern an activity (activity.java) of a city (cities.java)
    @GetMapping(path= "/{city}/{activity}/bonplan")
    public ResponseEntity<List<bonplan>> getBonPlan(@PathVariable("city") String city, @PathVariable("activity") String activity) {
        List<bonplan> allBP = bonplanService.getBonPlan(city, activity);
        return new ResponseEntity<>(allBP, HttpStatus.OK);
        }
    
    //Create a new Bon Plan (bonplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    //A refaire avec un post de l'objet et pas de ses variables séparemments
    @PostMapping(path= "/{city}/{activity}/newbonplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void postBonPlan(@RequestBody bonplan newBonPlan) {
        // String nameBP="newBP";
        // String adressCity="25 rue du beau";
        // String activityType="foot";
        // String nameCity = "Grenoble"; 
        bonplanService.createNewBonPlan(newBonPlan);
    }

    //Delete a Bon plan (bonplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    @DeleteMapping(path= "/{city}/{activity}/{name}")
    public void deleteBonPlan(@PathVariable("name") String name) {
        bonplanService.deleteThisBonPlan(name);
    }

    //Update a Bon plan (bonplan.java) embedded in a particular activity (activity.java) of a city (cities.java)
    @PutMapping(path= "/{city}/{activity}/updatebonplan", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateBonPlan(@RequestBody bonplan upBonPlan) {
        bonplanService.updateThisBonPlan(upBonPlan);
    }
}
