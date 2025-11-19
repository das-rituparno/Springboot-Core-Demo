package Security.Basic_Authentication.Controller;

import Security.Basic_Authentication.Entity.UserAuthEntity;
import Security.Basic_Authentication.Service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello World!";
    }

    @PostMapping("/reg")
    public ResponseEntity<String> register(@RequestBody UserAuthEntity userAuthDetails) {
        userAuthDetails.setPassword(passwordEncoder.encode(userAuthDetails.getPassword()));

        userAuthService.save(userAuthDetails);
        return ResponseEntity.ok("User registered successfully");
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserAuthEntity>> allUsers() {
        List<UserAuthEntity> all = userAuthService.showAll();
        return ResponseEntity.ok(all);
    }
}
