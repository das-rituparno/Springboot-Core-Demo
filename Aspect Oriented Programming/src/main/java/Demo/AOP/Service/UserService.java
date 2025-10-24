package Demo.AOP.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserById(int id) {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "User --> " + id;
    }

    public String createUser(String name) {
        return "Created User: " + name;
    }
}
