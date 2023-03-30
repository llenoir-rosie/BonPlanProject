package ProjetBonPlan.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.cities;
import jakarta.transaction.Transactional;


//link with Database 
@Repository
public interface CitiesRepository extends JpaRepository<cities, Long>{

    @Query("FROM cities WHERE name = ?1")
    public cities findByName(String name);

    @Query("FROM cities WHERE name in(SELECT city_name FROM cityactivities WHERE activity_name = ?1)")
    public List<cities> findByActivityToCity(String activity);

    //add new city in table cities
    @Modifying
    @Query("INSERT INTO cities (name,description,image) VALUES (?1 , ?2, ?3)")
    @Transactional
    public void CreateNewCity(String cityname, String description, String image);
   
    
    @Modifying
    @Query("DELETE FROM cities WHERE name=?1 and ?1 NOT IN (select city_name FROM cityactivities)")
    @Transactional
    public void DeleteCity(String name);
}
