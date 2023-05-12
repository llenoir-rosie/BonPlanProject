package ProjetBonPlan.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import ProjetBonPlan.controller.CitiesCtrler;
import ProjetBonPlan.model.cities;
import ProjetBonPlan.service.CitiesService;

@SpringBootTest
class CityControllerTest {
	
    @Autowired
    private CitiesService citiesService;
	
	@Test
	void testGetCityByName() throws Exception{		
		cities city = citiesService.getCityByName("Lyon");
		String nameCity = "Lyon";
		assertEquals(nameCity, city.getName());
	}

	@Test
	void testGetCitiesByActivity() throws Exception{
		List<cities> listCities = citiesService.getCitiesbyActivity("Basket");
		assertNotEquals(0, listCities.size());
	}

}
