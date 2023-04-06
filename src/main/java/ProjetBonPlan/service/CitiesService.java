package ProjetBonPlan.service;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.cities;
import ProjetBonPlan.repository.CitiesRepository;

@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;
    
    //renvoie la liste de toutes les villes de la base de données
    public List<cities> getAllCities() {
        return citiesRepository.findAll();
    }

    //renvoie la liste des villes disposant d'une activité précise
    public List<cities> getCitiesbyActivity(String activity){
        return citiesRepository.findByActivityToCity(activity);
    }

    //insert une nouvelle ville dans la base de données
    public void createNewCity(String cityname, String description, String image){
        citiesRepository.CreateNewCity(cityname, description, image);
    }
    
    //delete a city
    public void deleteCity(String name){
        citiesRepository.DeleteCity(name);
    }

    //Action that update an activity(activity.java) act 
    public void updateCity(cities cityToUpdate) {
        cities cityFromDb = citiesRepository.findByName(cityToUpdate.getName());
        cityFromDb.setName(cityToUpdate.getName());
        cityFromDb.setDescription("nouvelle description hahaha");
        cityFromDb.setImage(cityToUpdate.getImage());
        citiesRepository.save(cityFromDb);
        //activityFromDb.updateActivity(act);
    }

}
