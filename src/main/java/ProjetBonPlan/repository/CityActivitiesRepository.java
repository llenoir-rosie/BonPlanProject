package ProjetBonPlan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.cityactivities;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

@Repository
public interface CityActivitiesRepository extends JpaRepository<cityactivities,Long>{

    @Query("FROM cityactivities where city_name = ?1 and activity_name = ?2")
    public cityactivities findCityActivities(String cityname, String activityname);
    
    @Modifying
    //@Query("INSERT INTO cityactivities (city_name, activity_name, id) values (?1 , ?2, ((select count(*) from cityactivities)+1))")
    @Query ("insert into cityactivities (city_name, activity_name, id) values (?1, ?2, 0)")
    @Transactional
    public void CreateCityActivities(String cityname, String activityname);


    @Modifying
    @Query("DELETE FROM cityactivities WHERE city_name = ?1 AND activity_name = ?2")
    @Transactional
    public void DeleteCityActivities(String cityname, String activityname);
}
