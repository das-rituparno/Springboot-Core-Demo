package JPA.DerivedQuery;

import JPA.DerivedQuery.Entity.Employee;
import JPA.DerivedQuery.Repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DerivedQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DerivedQueryApplication.class, args);
	}

	// Automatically insert some employees on app startup
	@Bean
	public CommandLineRunner loadData(EmployeeRepository repo) {
		return args -> {
			repo.save(new Employee("Rituparno Das", "IT", 55000));
			repo.save(new Employee("Ankit Sharma", "HR", 45000));
			repo.save(new Employee("Priya Singh", "Finance", 60000));
			repo.save(new Employee("Sneha Roy", "Operations", 50000));
			System.out.println("✅ Employees inserted successfully!");
		};
	}

}
