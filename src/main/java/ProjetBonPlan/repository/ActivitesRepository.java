package ProjetBonPlan.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.activites;


//link with Database 
@Repository
public interface ActivitesRepository extends JpaRepository<activites, Long>{
    public Optional<activites> findByNom(String nom);
}
