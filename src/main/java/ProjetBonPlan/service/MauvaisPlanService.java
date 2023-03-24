package ProjetBonPlan.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.mauvaisplan;
import ProjetBonPlan.repository.MauvaisPlanRepository;

@Service
public class MauvaisPlanService {

    @Autowired
    private MauvaisPlanRepository mauvaisplanRepository;
    
    //@return all bonplan of an activity from a city
    public List<mauvaisplan> getMauvaisPlan(String city, String activity) {
        return mauvaisplanRepository.findMauvaisPlan(city, activity);
    }
}