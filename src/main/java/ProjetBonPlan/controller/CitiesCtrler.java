package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.cities;
import ProjetBonPlan.service.CitiesService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CitiesCtrler {

    @Autowired //if multiple constructor
    private CitiesService citiesService;

    //if HTTP request equals getAllCities promising a response of List of city in localhost://8080/cities
    @GetMapping(path= "/cities")
    public List<cities> getAllCities() {
        return citiesService.getAllCities();
    }

}
