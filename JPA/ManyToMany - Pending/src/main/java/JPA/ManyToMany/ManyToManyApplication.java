package JPA.ManyToMany;

import JPA.ManyToMany.Entity.Course;
import JPA.ManyToMany.Repo.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CourseRepository courseRepository) {
		return args -> {
			// Preload some courses
			courseRepository.save(new Course("Spring Boot"));
			courseRepository.save(new Course("Hibernate"));
			courseRepository.save(new Course("Microservices"));
		};
	}
}
