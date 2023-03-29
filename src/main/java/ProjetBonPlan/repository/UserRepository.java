package ProjetBonPlan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.User;
 
 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);





    /*Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);*/
 
    // User findByEmail(String email);
 
    // boolean existsByEmail(String email);
 
}
