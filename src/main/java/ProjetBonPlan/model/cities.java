package ProjetBonPlan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    
    @Column(name="post_code")
    private Integer postcode ;
 
    // getters and setters
}