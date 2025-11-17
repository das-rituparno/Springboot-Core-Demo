package JPA.NplusOneProblem.Entity;

import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.Star;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Professor> professors = new ArrayList<>();

    // Constructors
    public Department() {
    }
    public Department(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
