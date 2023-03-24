package ProjetBonPlan.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ProjetBonPlan.model.activites;
import jakarta.transaction.Transactional;
import ProjetBonPlan.model.cities;


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

    @Query("FROM cities WHERE name in(SELECT city_name FROM cityactivities WHERE activity_name = ?1)")
    public List<cities> findByActivitytocity(String activity);


    //add new city in table cities
    @Modifying
    @Query("INSERT INTO cities (name,description,image) values (?1 , ?2, ?3)")
    @Transactional
    public void CreateNewCity(String cityname, String description, String image);


    @Modifying
    @Query("INSERT INTO activites (nom,image,description,type) values (?1,?2,?3,?4)")
    //@Query("INSERT INTO activites (nom,image,description,type) values (?1,?2,?3,?4) ON CONFLICT (nom) DO NOTHING")
    @Transactional
    public void CreateNewActivity(String name, String image, String description, String type);

    @Modifying
    @Query("delete from cities where name=?1 and ?1 not in (select city_name from cityactivities)")
    @Transactional
    public void DeleteCity(String name);

    @Modifying
    @Query("delete from activites where nom=?1 and ?1 not in (select activity_name from cityactivities)")
    @Transactional
    public void DeleteActivity(String name);



}
