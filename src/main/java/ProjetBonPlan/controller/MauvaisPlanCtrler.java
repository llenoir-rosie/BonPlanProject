package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.model.mauvaisplan;
import ProjetBonPlan.service.ActivitesService;
import ProjetBonPlan.service.MauvaisPlanService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
public class MauvaisPlanCtrler {

    @Autowired //if multiple constructor
    private MauvaisPlanService bonplanService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path= "/{city}/{activites}/mauvais")
    public List<mauvaisplan> getMauvaisPlan(@PathVariable("city") String city, @PathVariable("activites") String activity) {
        return bonplanService.getMauvaisPlan(city, activity);
        }
    }
