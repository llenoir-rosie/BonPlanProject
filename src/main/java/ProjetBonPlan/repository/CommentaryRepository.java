package ProjetBonPlan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ProjetBonPlan.model.commentaires;
import jakarta.transaction.Transactional;

@Repository
public interface CommentaryRepository extends JpaRepository<commentaires, String>{
    
    @Query("FROM commentaires")
    public List<commentaires> findAllCommentaries();

    @Query("FROM commentaires WHERE bpName = ?1")
    public List<commentaires> findCommentariesOfBp(String bpname);

    @Query("FROM commentaires WHERE userName = ?1")
    public List<commentaires> findCommentariesOfUser(String username);

    @Query("FROM commentaires WHERE bpName = ?1 AND userName = ?1")
    public commentaires findCommentary(String bp_name, String username);

    @Modifying
    @Query("INSERT INTO commentaires (bpName, userName, note, commentaire, city_name, activity_name) VALUES (?1,?2,?3,?4,?5,?6)")
    @Transactional
    public void createCommentary(String bpname, String username, String note, String commentaire, String city_name, String activity_name);

    @Modifying
    @Query("DELETE FROM commentaires WHERE bpName = ?1 and userName = ?2")
    @Transactional
    public void deleteCommentary(String bpname, String username);
}
