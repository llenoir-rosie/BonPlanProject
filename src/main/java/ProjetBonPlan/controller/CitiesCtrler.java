package ProjetBonPlan.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.model.cities;
// import ProjetBonPlan.repository.CitiesRepository;
import ProjetBonPlan.service.CitiesService;

@RestController
@RequestMapping("/cities")
public class CitiesCtrler {

    @Autowired
    private CitiesService citiesService;

    @GetMapping
    public ResponseEntity<List<cities>> getAllCities() {
        return new ResponseEntity<List<cities>>(citiesService.getAllCities(), HttpStatus.OK);
    }
}
// public class CitiesCtrler {
    
//     @Autowired
//     CitiesRepository citiesRepository;

//     @GetMapping(value = "/cities")
//     public ResponseEntity<List<cities>> getAllTutorials(@RequestParam(required = false) String title) {
//         try {
//           List<cities> tutorials = new ArrayList<cities>();
    
//           if (title == null)
//             citiesRepository.findAll().forEach(tutorials::add);
    
//           if (tutorials.isEmpty()) {
//             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//           }
    
//           return new ResponseEntity<>(tutorials, HttpStatus.OK);
//         } catch (Exception e) {
//           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//       }
// }
