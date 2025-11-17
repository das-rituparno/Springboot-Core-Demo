package JPA.NplusOneProblem.Repo;

import JPA.NplusOneProblem.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Override
    List<Professor> findAll();
    @Query("SELECT p FROM Professor p JOIN FETCH p.department")
    List<Professor> findAllWithDepartment();
}
