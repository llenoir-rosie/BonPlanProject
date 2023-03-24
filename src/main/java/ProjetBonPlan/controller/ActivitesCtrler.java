package ProjetBonPlan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.model.cities;
import ProjetBonPlan.service.ActivitesService;


@RestController
// @RequestMapping("/api")
//servlet that concern CRUD of activities
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ActivitesCtrler {

    @Autowired //if multiple constructor
    private ActivitesService activitesService;

    //if HTTP request equals getAllCities promising a response of List of city in localhost://8080/cities
    @GetMapping(path= "/activites")
    public List<activites> getAllActivites() {
        return activitesService.getAllActivites();
        }

    //envoie le détail pour une activité
    

    @GetMapping(path="activites/precision_activite/{nom}")
    public activites getactivitesByNom(@PathVariable("nom") String nom){
        return activitesService.getactivitesByNom(nom);
    }

    //envoie toutes les activites d'une ville précisée dans le chemin
    @GetMapping(path="/{city}/activites")
    public List<activites> getActivitiesByCity(@PathVariable("city") String city){
        return activitesService.getActivitiesByCity(city);
    }

    //envoie toutes les villes disposant de l'activité précisée dans le chemin
    @GetMapping(path="villes/{activity}")
    public List<cities> getCitiesbyActivity(@PathVariable("activity") String activity){
        return activitesService.getCitiesbyActivity(activity);
    }
    /* 
    private String cityname="Lille";
    private String description="description de Lille";
    private String image="../assets/img/lille.jfif";*/

    //ajoute une nouvelle ville dans la base de donées si elle n existe pas encore
    @PostMapping(path="/city/new")
    //public void createNewCity(@RequestBody String villeAajouter,String DescriptionVille,String ImageVille){
     public void createNewCity(String cityname,String description,String image){
        String villeAajouter="Lille";
        String DescriptionVille="description de Lille";
        String ImageVille="../assets/img/lille.jfif";
        try{
            activitesService.createNewCity(villeAajouter,DescriptionVille,ImageVille);
        }catch(Exception e){
            System.out.println("Cette ville existe deja dans la base de donnees");
        }
        
    }

    //ajoute une nouvelle activité à la base de données si elle n existe pas encore
    @PostMapping(path="/activite/new")
    //public void createNewActivity(String act_name,String act_image, String act_description, String act_type)
    public void createNewActivity(String name, String image, String description, String type){
        String act_name = "basket";
        String act_description = "le basket c'est cool";
        String act_image = "../assets/img/basket.jfif";
        String act_type = "sport";
        try{
            activitesService.createNewActivity(act_name, act_image, act_description, act_type);
        }catch (Exception e){
            System.out.println("Cette activite a deja ete ajoutee");
        }
       
    }

    @DeleteMapping(path="city/delete")
    public void deleteCity(String name){
        name = "Lille";
        try{
            activitesService.deleteCity(name);
        }catch (Exception e){
            System.out.println("la ville ne peut pas etre supprimee");//affiche pas le message?
        }
    }

    @DeleteMapping(path="activite/delete")
    public void DeleteActivity(String name){
        name = "basket";
        try{
            activitesService.DeleteActivity(name);
        }catch (Exception e){
            System.out.println("l activite ne peut pas etre supprimee");//afficher pas le message?
        }
    }



}