package ProjetBonPlan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bonplan")
public class bonplan {

    @Id
    private String name;

    @Column 
    private String address;

    @Column
    private String activity_type;

    @Column 
    private String ville_name;

    @Column
    private String user_name;
    
    @Column
    private Float[] note;

    @Column 
    private String[] note_user;
    
    public String[] getNote_user() {
        return note_user;
    }

    public void setNote_user(String[] note_user) {
        this.note_user = note_user;
    }



    public String getVille_name() {
        return ville_name;
    }

    public void setVille_name(String ville_name) {
        this.ville_name = ville_name;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Float[] getNote() {
        return note;
    }

    public void setNote(Float[] note) {
        this.note = note;
    }

}
