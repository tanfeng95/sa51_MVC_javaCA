package team5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sa514105Team5Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Sa514105Team5Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> { 
			     
		};
	}

}
