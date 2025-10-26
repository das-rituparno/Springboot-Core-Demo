package Demo.FiltersChapter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/hello")
    public String sayHi() {
        System.out.println("🏁 Inside Controller");
        return "Hello from Controller!";
    }
}
