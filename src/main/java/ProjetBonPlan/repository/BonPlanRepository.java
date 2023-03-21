package ProjetBonPlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.bonplan;


//link with Database 
@Repository
public interface BonPlanRepository extends JpaRepository<bonplan, String>{

    @Query("FROM bonplan WHERE activity_type = ?2 AND ville_name = ?1")
    public List<bonplan> findBonPlan(String city, String activity);
}