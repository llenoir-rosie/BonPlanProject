package ProjetBonPlan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.User;
import jakarta.transaction.Transactional;
 
 
@Repository
public interface UserRepository extends JpaRepository<User, String> {
 
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String password);


    public User findByUsername(String username);
    
    // User findByEmail(String email);
 
    // boolean existsByEmail(String email);
    // @Modifying(clearAutomatically=true, flushAutomatically = true)
    // @Query("update users set password=?2 where username=?1")
    // @Transactional
    // void updatePassword(String username, String password);

    // public void deleteByUsername(String username);
    
    @Modifying
    @Query("DELETE FROM User WHERE username = ?1")
    @Transactional
    public void deleteByUsername(String username);

    @Query("from User where username = ?1")
    public User findImgByUsername(String username);

}
