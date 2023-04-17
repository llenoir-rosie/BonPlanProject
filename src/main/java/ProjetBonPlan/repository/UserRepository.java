package ProjetBonPlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.User;
 
 
@Repository
public interface UserRepository extends JpaRepository<User, String> {
 
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);


    public User findByUsername(String username);
    
    // User findByEmail(String email);
 
    // boolean existsByEmail(String email);
 
}
