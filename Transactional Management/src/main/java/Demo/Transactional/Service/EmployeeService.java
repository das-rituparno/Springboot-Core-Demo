package Demo.Transactional.Service;

import Demo.Transactional.Entity.Employee;
import Demo.Transactional.Repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void createUsers() {
        Employee user1 = new Employee("Alice", "alice@example.com");
        employeeRepository.save(user1);
        Employee user2 = new Employee("Bob", "bob@example.com");
        employeeRepository.save(user2);

        if (true) {
            throw new RuntimeException("Something went wrong! Transaction should rollback");
        }

        Employee user3 = new Employee("Charlie", "charlie@example.com");
        employeeRepository.save(user3);
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }
}
