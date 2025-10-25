package co.edu.uco.nose.nose.initializaer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ("co.edu.uco.nose")
public class ApiCapacitacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCapacitacionesApplication.class, args);
	}

}
