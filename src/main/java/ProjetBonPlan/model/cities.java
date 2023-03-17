package ProjetBonPlan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//return class cities definied by name, postcode and description
@Entity
@NoArgsConstructor //constructor with no args
@AllArgsConstructor //constructor with all args
@Table(name = "cities")
public class cities {

    private String name;
    private String postcode;
    private String description;

    @Id  //identify name as the primary key of cities
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public String getName() {
            return name;
        }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    @Column(name = "postcode", nullable = false)
    public String getPostCode() {
        return postcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "cities [name=" + name + ", postcode=" + postcode + ", description=" + description + "]";
    }
    
}