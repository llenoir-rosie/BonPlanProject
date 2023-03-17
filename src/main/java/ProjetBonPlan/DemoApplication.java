package ProjetBonPlan;


//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("ProjetBonPlan.model.*")  
@SpringBootApplication
public class DemoApplication {
	//implements CommandLineRunner
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
