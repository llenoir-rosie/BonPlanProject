package ProjetBonPlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.bonplan;
import jakarta.transaction.Transactional;


//link with Database 
@Repository
public interface BonPlanRepository extends JpaRepository<bonplan, String>{

    @Query("FROM bonplan WHERE activity_type = ?2 AND ville_name = ?1")
    public List<bonplan> findBonPlan(String city, String activity);

    @Modifying
    @Query("INSERT INTO bonplan (address, name,activity_type,ville_name) values (?2,?1,?3,?4)")
    @Transactional
    public void CreateNewBonPlan(String name, String address, String activity_type, String ville_name);

    @Modifying
    @Query("DELETE FROM bonplan WHERE name = ?1")
    @Transactional
    public void DeleteThisBonPlan(String name);

    @Query("SELECT COUNT(*) from bonplan where ville_name=?1 and activity_type=?2")
    public Integer countbonplan(String city, String activites);
}

