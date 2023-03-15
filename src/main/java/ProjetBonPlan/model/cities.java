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

    @Id
    @SequenceGenerator(
        name="cities_sequence",
        sequenceName = "cities_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "cities_sequence")

    private String name;
    private String postcode;
 
    public cities(String name, String postcode) {
        this.name = name;
        this.postcode = postcode;
    }
}