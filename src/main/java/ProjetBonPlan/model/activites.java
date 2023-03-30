package ProjetBonPlan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.Column;

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
    private String name;
    
    @Column
    private String description;

    @Column
    private String image;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getImage(){
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image=image;
    }

    @Override
    public String toString() {
        return "cities [nom=" + name + ", description=" + description  + ",image=" + image +"]";
    }
}