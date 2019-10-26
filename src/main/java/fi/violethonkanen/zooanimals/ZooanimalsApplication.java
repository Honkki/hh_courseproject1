package fi.violethonkanen.zooanimals;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.violethonkanen.zooanimals.domain.Animal;
import fi.violethonkanen.zooanimals.domain.AnimalRepository;

@SpringBootApplication
public class ZooanimalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooanimalsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AnimalRepository repository) {
		return (args) -> {
			Animal a1 = new Animal("Bob", "Male", 20.0);
			Animal a2 = new Animal("Sam", "Female", 13.5);
			Animal a3 = new Animal("Liz", "Female", 0.1);
			
			repository.save(a1);
			repository.save(a2);
			repository.save(a3);
		};
	}

}
