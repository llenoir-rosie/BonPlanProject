package ProjetBonPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.commentaires;
import ProjetBonPlan.repository.CommentaryRepository;

@Service
public class CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;
    
    public List<commentaires> getAllCommentaries() {
        return commentaryRepository.findAllCommentaries();
    }

    public List<commentaires> getCommentariesBp(String bpname) {
        return commentaryRepository.findCommentariesOfBp(bpname);
    }

    public List<commentaires> getCommentariesUser(String username) {
        return commentaryRepository.findCommentariesOfUser(username);
    }

    public void createCommentary(commentaires comment) {
        commentaryRepository.createCommentary(comment.getBpName(), comment.getUserName(), comment.getNote(), comment.getCommentaires(), comment.getCity(), comment.getActivity());
    }

    public void deleteCommentary(commentaires comment) {
        commentaryRepository.deleteCommentary(comment.getBpName(), comment.getUserName());
    }

    public void updateActivity(commentaires comment) {
        commentaires commentFromDB = commentaryRepository.findCommentary(comment.getBpName(), comment.getUserName());

        commentFromDB.setBpName(comment.getBpName());
        commentFromDB.setUserName(comment.getUserName());
        commentFromDB.setCommentaires(comment.getCommentaires());
        commentFromDB.setNote(comment.getNote());

        commentaryRepository.save(commentFromDB);
    }

}
