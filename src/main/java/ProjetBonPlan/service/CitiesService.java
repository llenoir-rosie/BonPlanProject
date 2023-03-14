package ProjetBonPlan.service;


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

    /*public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }**/

    public Iterable<cities> getCities() {
        return citiesRepository.findAll();
    }
}
