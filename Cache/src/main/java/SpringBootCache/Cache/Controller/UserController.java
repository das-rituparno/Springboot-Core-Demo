package SpringBootCache.Cache.Controller;

import SpringBootCache.Cache.Model.User;
import SpringBootCache.Cache.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PutMapping("/")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted & cache evicted";
    }

    @DeleteMapping("/clear")
    public String clearCache() {
        userService.clearCache();
        return "All cache cleared!";
    }
}
