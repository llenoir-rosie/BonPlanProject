package ProjetBonPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.commentary;
import ProjetBonPlan.repository.CommentaryRepository;

@Service
public class CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;
    
    public List<commentary> getAllCommentaries() {
        return commentaryRepository.findAllCommentaries();
    }

    public List<commentary> getCommentariesBp(String bpname) {
        return commentaryRepository.findCommentariesOfBp(bpname);
    }

    public List<commentary> getCommentariesUser(String username) {
        return commentaryRepository.findCommentariesOfUser(username);
    }

    public void createCommentary(commentary comment) {
        commentaryRepository.createCommentary(comment.getBpName(), comment.getUserName(), comment.getCommentaries());
    }

    public void deleteCommentary(commentary comment) {
        commentaryRepository.deleteCommentary(comment.getBpName(), comment.getUserName());
    }

    public void updateActivity(commentary comment) {
        commentary commentFromDB = commentaryRepository.findCommentary(comment.getBpName(), comment.getUserName());

        commentFromDB.setBpName(comment.getBpName());
        commentFromDB.setUserName(comment.getUserName());
        commentFromDB.setCommentaries(comment.getCommentaries());

        commentaryRepository.save(commentFromDB);
    }

}
