package Security.Basic_Authentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/hi")
    public String sayHello() {
        return "Hello world";
    }
}
