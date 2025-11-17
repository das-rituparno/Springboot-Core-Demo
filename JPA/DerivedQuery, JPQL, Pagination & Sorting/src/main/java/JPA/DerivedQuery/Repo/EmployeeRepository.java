package JPA.DerivedQuery.Repo;

import JPA.DerivedQuery.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findBySalaryGreaterThan(double salary, Pageable page);
    List<Employee> findByNameStartingWith(String prefix);

    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> findEqualSalaryEmployees(double salary);
}
