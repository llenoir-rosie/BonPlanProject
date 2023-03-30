package ProjetBonPlan.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.activites;
import jakarta.transaction.Transactional;
import ProjetBonPlan.model.cities;


//link with Database 
@Repository
public interface ActivitesRepository extends JpaRepository<activites, Long>{

    //renvoit la description complete d une activite, en parametre
    @Query("FROM activites WHERE name = ?1")
    public activites findbyactivite(String name);

    //renvoit la descritpion de toutes les activites possibles 
    // dans une ville precisee en parametre
    //@Query("SELECT activity_name FROM cityactivities WHERE city_name = ?1")
    //public List<String> findByCityActivities(String city);

    @Query("FROM activites WHERE name in (SELECT activity_name FROM cityactivities WHERE city_name = ?1)")
    public List<activites> findByCityActivities(String city);

    @Modifying
    @Query("INSERT INTO activites (name,image,description) values (?1,?2,?3)")
    //@Query("INSERT INTO activites (nom,image,description) values (?1,?2,?3) ON CONFLICT (nom) DO NOTHING")
    @Transactional
    public void CreateNewActivity(String name, String image, String description, String type);

    @Modifying
    @Query("DELETE FROM activites WHERE name=?1 and ?1 NOT IN (select activity_name FROM cityactivities)")
    @Transactional
    public void DeleteActivity(String name);

    
    
}
