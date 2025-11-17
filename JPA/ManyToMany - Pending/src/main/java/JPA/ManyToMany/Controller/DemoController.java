package JPA.ManyToMany.Controller;

import JPA.ManyToMany.Entity.Student;
import JPA.ManyToMany.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student, @RequestParam List<Long> courseIds) {
        return studentService.addStudentWithCourses(student, courseIds);
    }
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
