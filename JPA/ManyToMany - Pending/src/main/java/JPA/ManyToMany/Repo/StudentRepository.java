package JPA.ManyToMany.Repo;

import JPA.ManyToMany.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
