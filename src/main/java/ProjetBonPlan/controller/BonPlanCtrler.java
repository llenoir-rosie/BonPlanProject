package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.bonplan;
import ProjetBonPlan.service.ActivitesService;
import ProjetBonPlan.service.BonPlanService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class BonPlanCtrler {

    @Autowired //if multiple constructor
    private BonPlanService bonplanService;

    //Bonne Syntaxe
    @GetMapping(path= "/{city}/{activites}/bonplan")
    public ResponseEntity<List<bonplan>> getBonPlan(@PathVariable("city") String city, @PathVariable("activites") String activity) {
        List<bonplan> allBP = bonplanService.getBonPlan(city, activity);
        return new ResponseEntity<>(allBP, HttpStatus.OK);
        }
    
    //A refaire avec un post de l'objet et pas de ses variables séparemments
    @PostMapping(path= "/{city}/{activites}/newbonplan")
    public void postBonPlan(String name, String address, String activity_type, String ville_name) {
        String nameBP="newBP";
        String adressCity="25 rue du beau";
        String activityType="foot";
        String nameCity = "Grenoble"; 
        bonplanService.createNewBonPlan(nameBP,adressCity,activityType, nameCity);
    }

    //Appliquer La Bonne Syntaxe
    @DeleteMapping(path= "/{city}/{activites}/deletebonplan")
    public void deleteBonPlan(String name) {
        String nameBP = "newBP";
        bonplanService.deleteThisBonPlan(nameBP);
    }

    //Appliquer La Bonne Syntaxe
    @PutMapping(path= "/{city}/{activites}/updatebonplan")
    public void updateBonPlan(bonplan upBonPlan) {
        bonplanService.updateThisBonPlan(upBonPlan);
    }
}
