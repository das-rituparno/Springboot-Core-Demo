package Demo.AOP.Controller;

import Demo.AOP.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/create/{name}")
    public String createUser(@PathVariable String name) {
        return userService.createUser(name);
    }

    @GetMapping("/hi")
    public String demo() {
        return "Hello world";
    }
}
