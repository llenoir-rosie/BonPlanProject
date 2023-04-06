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

    public void createNewBonPlan(bonplan newBonPlan) {
        bonplanRepository.CreateNewBonPlan(newBonPlan.getName(), newBonPlan.getAddress(), newBonPlan.getActivity_type(), newBonPlan.getVille_name());
    }

    public void deleteThisBonPlan(String name) {
        bonplanRepository.DeleteThisBonPlan(name);
    }

    public void updateThisBonPlan(bonplan bonplanobj) {
        bonplan bonplanFromDb = bonplanRepository.findById(bonplanobj.getName()).get();
        bonplanFromDb.setAddress("nouvelle address");
        bonplanFromDb.setActivity_type(bonplanobj.getActivity_type());
        bonplanFromDb.setVille_name(bonplanobj.getVille_name());
        bonplanRepository.save(bonplanFromDb);
    }

    public Integer count(String city, String activites) {
        return bonplanRepository.countbonplan(city, activites);
    }
}