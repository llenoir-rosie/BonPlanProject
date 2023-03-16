package ProjetBonPlan.service;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProjetBonPlan.model.cities;
import ProjetBonPlan.repository.CitiesRepository;
import lombok.Data;

@Data
@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;

    public List<cities> getAllCities() {
        return citiesRepository.findAll();
    }
    
    // allCities = new ArrayList<cities>();
    // allCities = List.of(new cities("grenoble", "38000"));
    // return new ResponseEntity<>(allCities, HttpStatus.OK);
    // @Autowired
    // CitiesRepository citiesRepository;

    /*public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }**/
    
    // public List<cities> getAllCities() {
    //     return (List<cities>) citiesRepository.findAll();
    // }
}
