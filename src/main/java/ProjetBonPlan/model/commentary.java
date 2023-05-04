package ProjetBonPlan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "commentary")
public class commentary {
    
    @Column(name = "bpname")
    private String bpname;

    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "commentaries")
    private String commentaries;


    
    public commentary() {
    }
    
    public String getBpName() {
        return bpname;
    }

    public void setBpName(String bpname) {
        this.bpname = bpname;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(String commentaries) {
        this.commentaries = commentaries;
    }

}
