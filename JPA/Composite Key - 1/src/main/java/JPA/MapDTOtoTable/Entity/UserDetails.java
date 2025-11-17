package JPA.MapDTOtoTable.Entity;

import JPA.MapDTOtoTable.UserDetails_CompositeKey;
import jakarta.persistence.*;

@Table(name = "USER_DETAILS_TABLE")
@IdClass(UserDetails_CompositeKey.class)
@Entity
public class UserDetails {
    private Long id;
    @Id
    private String name;
    @Id
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
