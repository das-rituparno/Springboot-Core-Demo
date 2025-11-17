package JPA.NplusOneProblem.CLI;

import JPA.NplusOneProblem.Entity.Department;
import JPA.NplusOneProblem.Entity.Professor;
import JPA.NplusOneProblem.Repo.DepartmentRepository;
import JPA.NplusOneProblem.Repo.ProfessorRepository;
import JPA.NplusOneProblem.Service.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    @Autowired
    private RosterService rosterService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("...Saving test data...");
        Department physics = departmentRepository.save(new Department("Physics"));
        Department history = departmentRepository.save(new Department("History"));

        professorRepository.save(new Professor("Dr. Alice Smith", physics));
        professorRepository.save(new Professor("Dr. Bob Johnson", physics));
        professorRepository.save(new Professor("Dr. Carol Williams", history));
        System.out.println("...Test data saved...\n");

        // --- 2. Run the "Bad" N+1 Method ---
        rosterService.printRosterTheBadWay();

        // --- 3. Run the "Good" JOIN FETCH Method ---
        rosterService.printRosterTheGoodWay();
    }
}
