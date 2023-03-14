package ProjetBonPlan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.cities;
@Repository
public interface CitiesRepository extends CrudRepository<cities, Long> {
}
