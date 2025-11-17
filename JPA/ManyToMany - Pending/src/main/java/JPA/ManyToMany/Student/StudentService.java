package JPA.ManyToMany.Student;

import JPA.ManyToMany.Entity.Course;
import JPA.ManyToMany.Entity.Student;
import JPA.ManyToMany.Repo.CourseRepository;
import JPA.ManyToMany.Repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CourseRepository courseRepo;

    public Student addStudentWithCourses(Student student, List<Long> courseIds) {
        List<Course> courses = new ArrayList<>(courseRepo.findAllById(courseIds));
        student.setCourses(courses);
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
