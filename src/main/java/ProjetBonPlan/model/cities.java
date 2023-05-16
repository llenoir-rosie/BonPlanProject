package ProjetBonPlan.model;

import jakarta.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;

//return class cities definied by name, postcode and description

//@Getter
// @NoArgsConstructor 
// @AllArgsConstructor //constructor with all args
@Entity
@Table(name = "cities")
public class cities {

      //identify name as the primary key of cities
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String name;

    @Column
    private String description;

    @Column
    private String image;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image){
        this.image = image;
    }

    
}