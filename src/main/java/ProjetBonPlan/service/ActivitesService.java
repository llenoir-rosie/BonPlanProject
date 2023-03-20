package ProjetBonPlan.service;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.repository.ActivitesRepository;

@Service
public class ActivitesService {

    @Autowired
    private ActivitesRepository activitesRepository;
    
    public List<activites> getAllActivites() {
        return activitesRepository.findAll();
    }

}
