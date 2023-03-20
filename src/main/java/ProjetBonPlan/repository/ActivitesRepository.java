package ProjetBonPlan.repository;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.activites;
import ProjetBonPlan.model.cityactivities;


//link with Database 
@Repository
public interface ActivitesRepository extends JpaRepository<activites, Long>{
    public Optional<activites> findByNom(String nom);

    //renvoit la description complete d une activite, en parametre
    @Query("FROM activites WHERE nom = ?1")
    public activites findbyactivite(String nom);

    //renvoit la descritpion de toutes les activites possibles 
    // dans une ville precisee en parametre
    //@Query("SELECT activity_name FROM cityactivities WHERE city_name = ?1")
    //public List<String> findByCityActivities(String city);

    @Query("FROM activites WHERE nom in (SELECT activity_name FROM cityactivities WHERE city_name = ?1)")
    public List<activites> findByCityActivities(String city);


    
}
