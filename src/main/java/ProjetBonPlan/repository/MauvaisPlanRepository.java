package ProjetBonPlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.mauvaisplan;
import jakarta.transaction.Transactional;

//link with Database 
@Repository
public interface MauvaisPlanRepository extends JpaRepository<mauvaisplan, String>{
    
    @Query("FROM mauvaisplan WHERE activity_type = ?2 AND ville_name = ?1")
    public List<mauvaisplan> findMauvaisPlan(String city, String activity);

    @Query("FROM mauvaisplan WHERE user_name = ?1")
    public List<mauvaisplan> findUserMauvaisPlan(String username);
    

    @Modifying
    @Query("INSERT INTO mauvaisplan (address, name,activity_type,ville_name,user_name) values (?2,?1,?3,?4,?5)")
    @Transactional
    public void CreateNewMauvaisPlan(String name, String address, String activity_type, String ville_name, String user_name);

    @Modifying
    @Query("DELETE FROM mauvaisplan WHERE name = ?1")
    @Transactional
    public void DeleteThisMauvaisPlan(String name);

    @Query("SELECT COUNT(*) from mauvaisplan where ville_name=?1 and activity_type=?2")
    public Integer countbonplan(String city, String activites);
    
}
