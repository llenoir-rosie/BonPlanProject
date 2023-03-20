package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.service.ActivitesService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
public class ActivitesCtrler {

    @Autowired //if multiple constructor
    private ActivitesService activitesService;

    //if HTTP request equals getAllCities promising a response of List of city in localhost://8080/cities
    @CrossOrigin(origins = "*")
    @GetMapping(path= "/activites")
    public List<activites> getAllActivites() {
        return activitesService.getAllActivites();
        }

}