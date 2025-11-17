package JPA.DerivedQuery.Service;

import JPA.DerivedQuery.Entity.Employee;
import JPA.DerivedQuery.Repo.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Create
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read all
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll(Sort.by("salary").ascending());
    }

    // Read one
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
                .map(emp -> {
                    emp.setName(updatedEmployee.getName());
                    emp.setDepartment(updatedEmployee.getDepartment());
                    emp.setSalary(updatedEmployee.getSalary());
                    return employeeRepository.save(emp);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getHighPaidEmployees(double salary) {
        Pageable pageable = (Pageable) PageRequest.of(0,2);
        return employeeRepository.findBySalaryGreaterThan(salary, pageable);
    }

    public List<Employee> getNamesStartWith(String prefix) {
        return employeeRepository.findByNameStartingWith(prefix);
    }

    public List<Employee> findEqualSalaryWithJPQL(double salary) {
        return employeeRepository.findEqualSalaryEmployees(salary);
    }
}
