package ProjetBonPlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.mauvaisplan;

//link with Database 
@Repository
public interface MauvaisPlanRepository extends JpaRepository<mauvaisplan, String>{

    @Query("FROM mauvaisplan WHERE activity_type = ?2 AND ville_name = ?1")
    public List<mauvaisplan> findMauvaisPlan(String city, String activity);
}