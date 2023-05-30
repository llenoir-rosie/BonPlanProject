package ProjetBonPlan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "commentary")
public class commentaires {
    
    @Column(name = "bpname")
    private String bpName;

    @Column(name = "username")
    private String userName;

    @Column(name= "note")
    private String note;

    @Id
    @Column(name = "commentaries")
    private String commentaire;

    @Column(name="city_name")
    private String city_name;

    @Column(name="activity_name")
    private String activity_name;

    public commentaires() {
    }
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public String getBpName() {
        return bpName;
    }

    public void setBpName(String bpname) {
        this.bpName = bpname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getCommentaires() {
        return commentaire;
    }

    public void setCommentaires(String commentaires) {
        this.commentaire = commentaires;
    }

    public String getCity() {
        return city_name;
    }

    public void setCity(String city_name) {
        this.city_name = city_name;
    }

    public String getActivity() {
        return activity_name;
    }

    public void setActivity(String city_name) {
        this.activity_name = city_name;
    }
    

}
