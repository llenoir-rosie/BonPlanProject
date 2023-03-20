package ProjetBonPlan.service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.activites;
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

    public List<activites> getActivitiesByCity(String city){
        return activitesRepository.findByCityActivities(city);
    }

}
