package ProjetBonPlan.model;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "commentary")
public class commentary {
    
    @Id
    private String bpname;

    @Column
    private String username;

    @Column
    private String note;

    @Column
    private String commentaries;

    @Column(name="city_name")
    private String city_name;

    @Column(name="activity_name")
    private String activity_name;

    public String getCityname() {
        return city_name;
    }

    public void setCityname(String cityname) {
        this.city_name = cityname;
    }

    public String getActivityname() {
        return activity_name;
    }

    public void setActivityname(String activityname) {
        this.activity_name = activityname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
