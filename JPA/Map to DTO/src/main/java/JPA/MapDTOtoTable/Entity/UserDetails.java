package JPA.MapDTOtoTable.Entity;

import jakarta.persistence.*;

@Table(name = "USER_DETAILS_TABLE",
        schema = "ONBOARDING",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "phone"),
                @UniqueConstraint(columnNames = {"name", "email"})
        },
        indexes = {
        @Index(name = "index_phone", columnList = "phone"),
                @Index(name = "index_name_email", columnList = "name, email")
        })
@Entity
public class UserDetails {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_user_seq")
    @SequenceGenerator(name = "unique_user_seq",
            sequenceName = "sb_seq_name",
            initialValue = 100,
            allocationSize = 5)
    private Long id;
    @Column(name = "name", unique = true, nullable = false, length = 255)
    private String name;
    private String email;
    private String phone;

    // Constructor without any arguments
    public UserDetails() {
    }

    //Getter and Setter

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
