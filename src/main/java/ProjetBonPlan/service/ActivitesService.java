package ProjetBonPlan.service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.model.cities;
import ProjetBonPlan.model.cityactivities;
import ProjetBonPlan.repository.ActivitesRepository;

@Service
public class ActivitesService {

    @Autowired
    private ActivitesRepository activitesRepository;
    
    public List<activites> getAllActivites() {
        return activitesRepository.findAll();
    }

    public activites getactivitesByNom(String nom){
        return activitesRepository.findbyactivite(nom);
    }

    //renvoie la liste des activités possibles dans une ville
    public List<activites> getActivitiesByCity(String city){
        return activitesRepository.findByCityActivities(city);
    }

    //renvoie la liste des villes disposant d'une activité précise
    public List<cities> getCitiesbyActivity(String activity){
        return activitesRepository.findByActivitytocity(activity);
    }

    //insert une nouvelle ville dans la base de données
    public void createNewCity(String cityname, String description, String image){
        activitesRepository.CreateNewCity(cityname, description, image);
    }
    

    //insert une nouvelle activité dans la table activités
    public void createNewActivity(String name,String image, String description, String type){
        activitesRepository.CreateNewActivity(name, image, description, type);
    }

    //delete a city
    public void deleteCity(String name){
        activitesRepository.DeleteCity(name);
    }

    public void DeleteActivity(String name){
        activitesRepository.DeleteActivity(name);
    }

}
