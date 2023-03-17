package ProjetBonPlan.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.cities;


//link with Database 
@Repository
public interface CitiesRepository extends JpaRepository<cities, Long>{
    public Optional<cities> findByName(String name);
}
