package Demo.Transactional.Controller;

import Demo.Transactional.Entity.Employee;
import Demo.Transactional.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/create-user")
    public String createUsers() {
        try {
            employeeService.createUsers();
        } catch (Exception e) {
            return "Transaction rolled back: " + e.getMessage();
        }
        return "Users created successfully";
    }

    @GetMapping("/all")
    public List<Employee> employeeList() {
        return employeeService.allEmployee();
    }
}
