package ProjetBonPlan.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.activity;
import jakarta.transaction.Transactional;



//link with Database 
@Repository
public interface ActivityRepository extends JpaRepository<activity, Long>{

    //renvoit la description complete d une activite, en parametre
    @Query("FROM activity WHERE name = ?1")
    public activity findByActivity(String name);

    //renvoit la descritpion de toutes les activites possibles 
    // dans une ville precisee en parametre
    //@Query("SELECT activity_name FROM cityactivities WHERE city_name = ?1")
    //public List<String> findByCityActivities(String city);

    @Query("FROM activity WHERE name in (SELECT activity_name FROM cityactivities WHERE city_name = ?1)")
    public List<activity> findByCityActivities(String city);

    @Modifying
    @Query("INSERT INTO activity (name,image,description) values (?1,?2,?3)")
    //@Query("INSERT INTO activites (nom,image,description) values (?1,?2,?3) ON CONFLICT (nom) DO NOTHING")
    @Transactional
    public void CreateNewActivity(String name, String image, String description);

    @Modifying
    @Query("DELETE FROM activity WHERE name=?1 and ?1 NOT IN (select activity_name FROM cityactivities)")
    @Transactional
    public void DeleteActivity(String name);

    @Query("FROM activity WHERE name = ?1")
    public activity findByImgActivity(String activity_name);
    
}
