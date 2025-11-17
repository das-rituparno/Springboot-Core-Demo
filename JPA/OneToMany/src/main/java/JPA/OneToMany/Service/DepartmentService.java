package JPA.OneToMany.Service;

import JPA.OneToMany.Entity.Department;
import JPA.OneToMany.Entity.Employee;
import JPA.OneToMany.Repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        // Set the department reference in each employee before saving
        for (Employee e : department.getEmployees()) {
            e.setDepartment(department);
        }
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
