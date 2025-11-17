package JPA.MapDTOtoTable;

import java.io.Serializable;
import java.util.Objects;

public class UserDetails_CompositeKey implements Serializable {
    private String name;
    private String email;

    public UserDetails_CompositeKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails_CompositeKey that = (UserDetails_CompositeKey) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
