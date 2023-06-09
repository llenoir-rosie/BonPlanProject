package ProjetBonPlan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.activity;
import ProjetBonPlan.repository.ActivityRepository;

@Service
public class ActivitesService {

    @Autowired
    private ActivityRepository activitesRepository;
    
    public List<activity> getAllActivites() {
        return activitesRepository.findAll();
    }

    public activity getactivitesByNom(String nom){
        return activitesRepository.findByActivity(nom);
    }

    //renvoie la liste des activités possibles dans une ville
    public List<activity> getActivitiesByCity(String city){
        return activitesRepository.findByCityActivities(city);
    }
    

    //insert une nouvelle activité dans la table activités
    public void createNewActivity(String name,String image, String description){
        activitesRepository.CreateNewActivity(name, image, description);
    }

    public void DeleteActivity(String name){
        activitesRepository.DeleteActivity(name);
    }

    //Action that update an activity(activites.java) act 
    public void updateActivity(activity act) {
        activity activityFromDb = activitesRepository.findByActivity(act.getName());
        activityFromDb.setName(act.getName());
        activityFromDb.setDescription("nouvelle description hahaha");
        activityFromDb.setImage(act.getImage());
        activitesRepository.save(activityFromDb);
        //activityFromDb.updateActivity(act);
    }

}
