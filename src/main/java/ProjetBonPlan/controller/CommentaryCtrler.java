package ProjetBonPlan.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.commentaires;
import ProjetBonPlan.service.CommentaryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CommentaryCtrler {
    
    @Autowired
    private CommentaryService commentaryService;

    @GetMapping(path = "/commentaries")
    public List<commentaires> getAllCommentaries() {
        return commentaryService.getAllCommentaries();
    }
    @GetMapping(path= "/getByBP/commentaries/{bpname}")
    public ResponseEntity<List<commentaires>> getBonPlan(@PathVariable("bpname") String bpname) {
        List<commentaires> allBPCommentaries = commentaryService.getCommentariesBp(bpname);
        return new ResponseEntity<>(allBPCommentaries, HttpStatus.OK);
        }

    @GetMapping(path = "/getByUser/commentaries/{username}")
    public List<commentaires> getCommentariesUser(@PathVariable("username") String username) {
        return commentaryService.getCommentariesUser(username);
    }

    @PostMapping(path = "/commentaries/create/{bpname}/{username}", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCommentary(@RequestBody commentaires comment) throws IOException, InterruptedException {
        // String bpname = comment.getBpName();
        // String username = comment.getUserName();
        // String commentary = comment.getCommentaries();
        System.out.println("Object commentaire reçu : ") ;
        System.out.println(comment.getActivity());
        commentaryService.createCommentary(comment);
    }

    @DeleteMapping(path = "/commentaries/delete", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCommentary(@RequestBody commentaires comment)  throws IOException, InterruptedException {
        try{
            commentaryService.deleteCommentary(comment);
        }catch (Exception e){
            System.out.println("l activite ne peut pas etre supprimee");//afficher pas le message?
        }
    }

    @PutMapping(path = "/commentaries/update", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateActivity(@RequestBody commentaires comment) throws IOException, InterruptedException {
        commentaryService.updateActivity(comment);
    }
}
