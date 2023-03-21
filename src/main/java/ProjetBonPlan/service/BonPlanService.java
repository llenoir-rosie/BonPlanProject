package ProjetBonPlan.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.bonplan;
import ProjetBonPlan.repository.BonPlanRepository;

@Service
public class BonPlanService {

    @Autowired
    private BonPlanRepository bonplanRepository;
    
    //@return all bonplan of an activity from a city
    public List<bonplan> getBonPlan(String city, String activity) {
        return bonplanRepository.findBonPlan(city, activity);
    }
}