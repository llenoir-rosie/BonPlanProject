package ProjetBonPlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.User;
 
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
    // User findByEmail(String email);
 
    // boolean existsByEmail(String email);
 
}
