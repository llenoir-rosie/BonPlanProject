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

    @Query("FROM bonplan WHERE user_name = ?1")
    public List<bonplan> findUserBonPlan(String username);
    
    @Modifying
    @Query("INSERT INTO bonplan (address, name,activity_type, ville_name, user_name, note) values (?2,?1,?3,?4,?5,?6)")
    @Transactional
    public void CreateNewBonPlan(String name, String address, String activity_type, String ville_name, String user_name,
    Float[] note);

    @Modifying
    @Query("DELETE FROM bonplan WHERE name = ?1")
    @Transactional
    public void DeleteThisBonPlan(String name);

    @Query("SELECT COUNT(*) from bonplan where ville_name=?1 and activity_type=?2")
    public Integer countbonplan(String city, String activites);

    // @Query("SELECT note nb_note FROM bonplan WHERE ville_name=?1 and activity_type=?2 and name=?3")
    // public Integer[] getNoteBonPlan(String city, String activity, String name);
}

