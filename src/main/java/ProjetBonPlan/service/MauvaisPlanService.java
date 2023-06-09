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
    
    //@return all mauvaisplan of an activity from a city
    public List<mauvaisplan> getMauvaisPlan(String city, String activity) {
        return mauvaisplanRepository.findMauvaisPlan(city, activity);
    }

    public List<mauvaisplan> getUserMauvaisPlan(String username) {
        return mauvaisplanRepository.findUserMauvaisPlan(username);
    }

    public void createNewMauvaisPlan(mauvaisplan newMauvaisPlan) {
        mauvaisplanRepository.CreateNewMauvaisPlan(newMauvaisPlan.getName(), newMauvaisPlan.getAddress(), newMauvaisPlan.getActivity_type(), newMauvaisPlan.getVille_name(), newMauvaisPlan.getUser_name());
    }

    public void deleteThisMauvaisPlan(String name) {
        mauvaisplanRepository.DeleteThisMauvaisPlan(name);
    }

    public void updateThisMauvaisPlan(mauvaisplan mauvaisplanobj) {
        mauvaisplan mauvaisplanFromDb = mauvaisplanRepository.findById(mauvaisplanobj.getName()).get();
        mauvaisplanFromDb.setAddress(mauvaisplanobj.getAddress());
        mauvaisplanFromDb.setActivity_type(mauvaisplanobj.getActivity_type());
        mauvaisplanFromDb.setVille_name(mauvaisplanobj.getVille_name());
        mauvaisplanRepository.save(mauvaisplanFromDb);
    }

    public Integer count(String city, String activites) {
        return mauvaisplanRepository.countbonplan(city, activites);
    }
}
