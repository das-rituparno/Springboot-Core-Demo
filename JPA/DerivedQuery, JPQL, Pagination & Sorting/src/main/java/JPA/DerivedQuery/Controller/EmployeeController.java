package JPA.DerivedQuery.Controller;

import JPA.DerivedQuery.Entity.Employee;
import JPA.DerivedQuery.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/high-salary/{amount}")
    public List<Employee> getHighSalaryEmployees(@PathVariable double amount) {
        return employeeService.getHighPaidEmployees(amount);
    }

    @GetMapping("/name-starts-with/{prefix}")
    public List<Employee> similarNames(@PathVariable String prefix) {
        return employeeService.getNamesStartWith(prefix);
    }

    @GetMapping("/jpql/{salary}")
    public List<Employee> findSalaryWithJPQL(@PathVariable double salary) {
        return employeeService.findEqualSalaryWithJPQL(salary);
    }
}
