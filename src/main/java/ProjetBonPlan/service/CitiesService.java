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
    
    public List<cities> getAllCities() {
        return citiesRepository.findAll();
    }

}
