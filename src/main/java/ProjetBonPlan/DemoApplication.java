package ProjetBonPlan;

import java.util.List;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.sym.Name;

import ProjetBonPlan.model.cities;

@SpringBootApplication
public class DemoApplication {
	//implements CommandLineRunner
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
