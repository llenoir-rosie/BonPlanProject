package ProjetBonPlan.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    //@return a city (cities.java) selected by its props city.name
    @GetMapping(path="city/{nom}")
    public cities getCityByName(@PathVariable("nom") String nom){
        return citiesService.getCityByName(nom);
    }

    //@return all cities which have the activity (activity) (name of the activity in the path)
    @GetMapping(path="villes/{activity}")
    public List<cities> getCitiesbyActivity(@PathVariable("activity") String activity){
        return citiesService.getCitiesbyActivity(activity);
    }

    //Create a new city (cities.java), return false if the name already exist
    @PostMapping(path="/city/new")
        public void createNewCity(@RequestBody cities City) throws IOException, InterruptedException{
        String cityName = City.getName();
        String cityDescription = City.getDescription();
        String cityImage = City.getImage();

        if (cityImage != ""){
            String user = (((System.getProperty("user.home")).split("Users"))[1]).replace("\\","");
            String src = "C:/Users/" + user + "/Downloads/" + cityImage;
            String dest = "C:/Users/" + user + "/BonPlanFront/src/assets/img/" + cityImage;
            // File file1 = new File(src);
            File file2 = new File(dest);
            TimeUnit.SECONDS.sleep(1);
   
            if (!file2.exists()){ //si l image n existe pas dans le dossier image /assets/img, le deplacer
                Files.move(Paths.get(src), Paths.get(dest));
            }
            cityImage = "../assets/img/" + cityImage;
            City.setImage(cityImage);
            System.out.println(cityImage);

            Files.delete(Paths.get(src)); //suppr fichier saved by file-saver dans downloads
        }else{
            cityImage = "";
        }

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
    public void updateCity(@RequestBody cities cityToUpdate) throws InterruptedException, IOException {
        String city_name = cityToUpdate.getName();
        //String city_description = cityToUpdate.getDescription();
        String city_image = cityToUpdate.getImage();

        if (city_image != ""){
            String user = (((System.getProperty("user.home")).split("Users"))[1]).replace("\\","");
            String src = "C:/Users/" + user + "/Downloads/" + city_image;
            String dest = "C:/Users/" + user + "/BonPlanFront/src/assets/img/" + city_image;
            //File file1 = new File(src);
            File file2 = new File(dest);
            TimeUnit.SECONDS.sleep(1);

            if (!file2.exists()){ //si l image n existe pas dans le dossier image /assets/img, le deplacer
                Files.move(Paths.get(src), Paths.get(dest));
            }
            city_image = "../assets/img/" + city_image ;
            cityToUpdate.setImage(city_image);
            Files.delete(Paths.get(src));
        }else{
            cityToUpdate.setImage(citiesService.getCityByName(city_name).getImage());
        }

        try{
            citiesService.updateCity(cityToUpdate);
        } catch (Exception e) {
            System.out.println("l activite ne peut pas etre mise à jour");
        }
    }


}
