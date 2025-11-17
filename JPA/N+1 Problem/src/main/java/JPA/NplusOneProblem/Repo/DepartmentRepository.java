package JPA.NplusOneProblem.Repo;

import JPA.NplusOneProblem.Entity.Department;
import JPA.NplusOneProblem.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
