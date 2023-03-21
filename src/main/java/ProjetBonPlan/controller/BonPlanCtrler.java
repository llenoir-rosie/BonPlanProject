package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.model.bonplan;
import ProjetBonPlan.service.ActivitesService;
import ProjetBonPlan.service.BonPlanService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
public class BonPlanCtrler {

    @Autowired //if multiple constructor
    private BonPlanService bonplanService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path= "/{city}/{activites}/bonplan")
    public List<bonplan> getBonPlan(@PathVariable("city") String city, @PathVariable("activites") String activity) {
        return bonplanService.getBonPlan(city, activity);
        }

}