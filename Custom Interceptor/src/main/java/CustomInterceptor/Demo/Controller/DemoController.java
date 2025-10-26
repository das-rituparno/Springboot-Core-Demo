package CustomInterceptor.Demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/hello")
    public String greetings() {
        System.out.println("ACTUAL CODE");
        return "Hello from the Interceptor demo";
    }

    @GetMapping("/hi")
    public String sayHello() {
        return "controller is working fine";
    }
}
