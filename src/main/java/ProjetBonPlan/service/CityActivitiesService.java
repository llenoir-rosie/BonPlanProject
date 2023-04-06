package ProjetBonPlan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetBonPlan.model.cityactivities;
import ProjetBonPlan.repository.CityActivitiesRepository;

@Service
public class CityActivitiesService {
    @Autowired
    CityActivitiesRepository cityActivitiesRepository;

    public cityactivities getCityActivities(String cityname, String activityname){
        return cityActivitiesRepository.findCityActivities(cityname, activityname);
    }

    public void CreateCityActivities(String cityname, String activityname){
        cityActivitiesRepository.CreateCityActivities(cityname, activityname);
    }

    public void DeleteCityActivities(String cityname, String activityname){
        cityActivitiesRepository.DeleteCityActivities(cityname, activityname);
    }


}
