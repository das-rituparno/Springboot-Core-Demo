package JPA.NplusOneProblem.Service;

import JPA.NplusOneProblem.Entity.Professor;
import JPA.NplusOneProblem.Repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RosterService {
    @Autowired
    private ProfessorRepository professorRepository;

    // --- The "Bad" Method (Causes N+1) ---
    @Transactional(readOnly = true)
    public void printRosterTheBadWay() {
        System.out.println("\n--- RUNNING 'BAD' N+1 METHOD ---");

        // 1. The "1" Query
        List<Professor> professors = professorRepository.findAll();
        System.out.println("...Fetched all professors (1 query)...");

        System.out.println("--- Roster ---");
        // 2. The "N" Queries
        for (Professor prof : professors) {
            // This line triggers a new query for EACH professor
            System.out.println(
                    "Professor: " + prof.getName() +
                            " | Department: " + prof.getDepartment().getName() // <-- N+1 Trigger
            );
        }
        System.out.println("-------------------------------------\n");
    }

    // --- The "Good" Method (Fixed with JOIN FETCH) ---
    @Transactional(readOnly = true)
    public void printRosterTheGoodWay() {
        System.out.println("\n--- RUNNING 'GOOD' JOIN FETCH METHOD ---");

        // 1. The "1" (and only) Query
        List<Professor> professors = professorRepository.findAllWithDepartment();
        System.out.println("...Fetched all professors AND departments (1 query)...");

        System.out.println("--- Roster (Optimized) ---");
        // 2. No More Queries!
        for (Professor prof : professors) {
            // This line is now "free" and triggers NO new queries.
            System.out.println(
                    "Professor: " + prof.getName() +
                            " | Department: " + prof.getDepartment().getName()
            );
        }
        System.out.println("----------------------------------------\n");
    }
}
