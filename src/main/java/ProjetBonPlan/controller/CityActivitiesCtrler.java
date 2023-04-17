package ProjetBonPlan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ProjetBonPlan.service.CityActivitiesService;
import ProjetBonPlan.model.cityactivities;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CityActivitiesCtrler {

    @Autowired
    CityActivitiesService cityActivitiesService;

    @PostMapping(path="/cityactivities/new", consumes = MediaType.APPLICATION_JSON_VALUE, 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public void createNewCityActivity(@RequestBody cityactivities CityActivity) throws Exception{
        String cityname = CityActivity.getCity();
        String activityname = CityActivity.getActivity();
        
        if (cityActivitiesService.getCityActivities(cityname,activityname) == null){
            cityActivitiesService.CreateCityActivities(cityname, activityname);
        }else{
            throw new Exception("l activite " + activityname + " existe deja pour " + cityname);
        }
        
    }

    @DeleteMapping(path="/cityactivities/delete/{cityname}/{activityname}")
    public void deleteCityActivity(@PathVariable("cityname") String cityname, @PathVariable("activityname") String activityname ){
        
        cityActivitiesService.DeleteCityActivities(cityname, activityname);
    }
    
}
