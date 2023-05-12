package ProjetBonPlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.commentary;
import jakarta.transaction.Transactional;

@Repository
public interface CommentaryRepository extends JpaRepository<commentary, String>{
    
    @Query("FROM commentary")
    public List<commentary> findAllCommentaries();

    @Query("FROM commentary WHERE bpname = ?1 AND city_name= ?2 AND activity_name=?3")
    public List<commentary> findCommentariesOfBp(String bpname, String city_name, String activity_name);

    @Query("FROM commentary WHERE username = ?1")
    public List<commentary> findCommentariesOfUser(String username);

    @Query("FROM commentary WHERE bpname = ?1 AND username = ?1")
    public commentary findCommentary(String bp_name, String username);

    @Modifying
    @Query("INSERT INTO commentary(bpname, username, commentaries, note, city_name, activity_name) VALUES (?1,?2,?3,?4,?5,?6)")
    @Transactional
    public void createCommentary(String bpname, String username, String commentary, String note, String city_name, String activity_name);

    @Modifying
    @Query("DELETE FROM commentary WHERE bpname = ?1 and username = ?2")
    @Transactional
    public void deleteCommentary(String bpname, String username);


}
