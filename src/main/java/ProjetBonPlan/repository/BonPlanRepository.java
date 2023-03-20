package ProjetBonPlan.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.bonplan;


//link with Database 
@Repository
public interface BonPlanRepository {

    @Query()
    public bonplan getBonPlan();
}