package ProjetBonPlan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.SequenceGenerator;

@Entity
@Table(name = "cities")
public class cities {

    @SequenceGenerator(
        name="cities_sequence",
        sequenceName = "cities_sequence",
        allocationSize = 1
    )
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String postcode;
    private String description;
 
    public cities(String name, String description, String postcode) {
        this.name = name;
        this.description = description;
        this.postcode = postcode;
    }
}