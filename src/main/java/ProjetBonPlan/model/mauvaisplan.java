package ProjetBonPlan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mauvaisplan")
public class mauvaisplan {
    
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
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public String getVille_name() {
        return ville_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public void setVille_name(String ville_name) {
        this.ville_name = ville_name;
    }

}
