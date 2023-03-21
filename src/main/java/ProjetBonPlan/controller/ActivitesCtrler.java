package ProjetBonPlan.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ProjetBonPlan.model.activites;
import ProjetBonPlan.model.cityactivities;
import ProjetBonPlan.service.ActivitesService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
public class ActivitesCtrler {

    @Autowired //if multiple constructor
    private ActivitesService activitesService;

    //if HTTP request equals getAllCities promising a response of List of city in localhost://8080/cities
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path= "/activites")
    public List<activites> getAllActivites() {
        return activitesService.getAllActivites();
        }

    @GetMapping(path="activites/precision_activite/{nom}")
    public activites getactivitesByNom(@PathVariable("nom") String nom){
        return activitesService.getactivitesByNom(nom);
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path="/{city}/activites")
    public List<activites> getActivitiesByCity(@PathVariable("city") String city){
        return activitesService.getActivitiesByCity(city);
    }

    

}