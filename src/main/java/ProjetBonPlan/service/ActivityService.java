package ProjetBonPlan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.activity;
import ProjetBonPlan.repository.ActivityRepository;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    
    public List<activity> getAllActivity() {
        return activityRepository.findAll();
    }

    public activity getActivityByNom(String nom){
        return activityRepository.findByActivity(nom);
    }

    //renvoie la liste des activités possibles dans une ville
    public List<activity> getActivitiesByCity(String city){
        return activityRepository.findByCityActivities(city);
    }
    

    //insert une nouvelle activité dans la table activités
    public void createNewActivity(String name,String image, String description){
        activityRepository.CreateNewActivity(name, image, description);
    }

    public void DeleteActivity(String name){
        activityRepository.DeleteActivity(name);
    }

    //Action that update an activity(activity.java) act 
    public void updateActivity(activity act) {
        activity activityFromDb = activityRepository.findByActivity(act.getName());
        activityFromDb.setName(act.getName());
        activityFromDb.setDescription(act.getDescription());
        activityFromDb.setImage(act.getImage());
        activityRepository.save(activityFromDb);
        //activityFromDb.updateActivity(act);
    }

}
