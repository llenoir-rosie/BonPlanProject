package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.activity;
import ProjetBonPlan.model.cities;
import ProjetBonPlan.service.CitiesService;

@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of cities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CitiesCtrler {

    @Autowired //If multiple constructor
    private CitiesService citiesService;

    //If HTTP request equals getAllCities promising a response of List of city in localhost://8080/cities
    //@return All city (cities.java)
    @GetMapping(path= "/cities")
    public List<cities> getAllCities() {
        return citiesService.getAllCities();
    }

    //@return all cities which have the activity (activity) (name of the activity in the path)
    @GetMapping(path="villes/{activity}")
    public List<cities> getCitiesbyActivity(@PathVariable("activity") String activity){
        return citiesService.getCitiesbyActivity(activity);
    }

    //Create a new city (cities.java), return false if the name already exist
    @PostMapping(path="/city/new")
        public void createNewCity(@RequestBody cities City){
        //public void createNewCity(String cityname,String description,String image)
        String cityName = City.getName();
        String cityDescription = City.getDescription();
        String cityImage = City.getImage();
        try{
            citiesService.createNewCity(cityName,cityDescription, cityImage);
        }catch(Exception e){
            System.out.println("Cette ville existe deja dans la base de donnees");
        }
        
    }

    //Delete the city, return false if user doesn't have the rights
    @DeleteMapping(path="city/delete")
    public void deleteCity(String name){
        name = "Lille";
        try{
            citiesService.deleteCity(name);
        }catch (Exception e){
            System.out.println("la ville ne peut pas etre supprimee");//affiche pas le message?
        }
    }

    //Update a City (cities.java), return false if the city can't be updated
    @PutMapping(path="city/update", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCity(@RequestBody cities cityToUpdate) {
        try{
            citiesService.updateCity(cityToUpdate);
        } catch (Exception e) {
            System.out.println("l activite ne peut pas etre mise à jour");
        }
    }


}
