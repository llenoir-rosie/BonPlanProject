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
@Table(name = "cityactivities")
public class cityactivities {

      //identify name as the primary key of cities
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    
    @Column
    private String city_name;

    @Column
    private String activity_name;


    public String getCity() {
        return city_name;
    }

    public String getActivity() {
        return activity_name;
    }

    public void setCity(String city_name) {
        this.city_name = city_name;
    }

    public void setActivity(String activity_name) {
        this.activity_name = activity_name;
    }
    
    @Override
    public String toString() {
        return "cities/activities [city=" + city_name + ", activity=" + activity_name  + "]";
    }
}