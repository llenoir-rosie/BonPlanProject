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

    @Query("FROM commentary WHERE bpname = ?1")
    public List<commentary> findCommentariesOfBp(String bpname);

    @Query("FROM commentary WHERE username = ?1")
    public List<commentary> findCommentariesOfUser(String username);

    @Query("FROM commentary WHERE bpname = ?1 AND username = ?1")
    public commentary findCommentary(String bp_name, String username);

    @Modifying
    @Query("INSERT INTO commentary(bpname, username, commentaries, note) VALUES (?1,?2,?3,?4)")
    @Transactional
    public void createCommentary(String bpname, String username, String commentary, String note);

    @Modifying
    @Query("DELETE FROM commentary WHERE bpname = ?1 and username = ?2")
    @Transactional
    public void deleteCommentary(String bpname, String username);


}
