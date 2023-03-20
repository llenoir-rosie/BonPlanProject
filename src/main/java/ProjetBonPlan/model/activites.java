package ProjetBonPlan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.DialectOverride.ColumnDefault;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//return class cities definied by name, postcode and description

//@Getter
// @NoArgsConstructor //constructor with no args
// @AllArgsConstructor //constructor with all args
@Entity
@Table(name = "activites")
public class activites {

      //identify name as the primary key of cities
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String nom;
    
    @Column
    private String description;

    @Column
    private String image;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return nom;
    }

    public String getImage(){
        return image;
    }


    public void setName(String nom) {
        this.nom = nom;
    }

    public void setImage(String image) {
        this.image=image;
    }

    @Override
    public String toString() {
        return "cities [nom=" + nom + ",image=" + image + "description=" + description + "]";
    }
}