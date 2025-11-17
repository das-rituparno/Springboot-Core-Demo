package JPA.MapDTOtoTable.Entity;

import JPA.MapDTOtoTable.UserDetails_CompositeKey;
import jakarta.persistence.*;

@Table(name = "USER_DETAILS_TAB")
@Entity
public class UserDetails {
    private Long id;
    @EmbeddedId
    UserDetails_CompositeKey userDetails_ck;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
