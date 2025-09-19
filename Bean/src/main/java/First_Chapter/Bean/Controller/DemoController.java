package First_Chapter.Bean.Controller;

import First_Chapter.Bean.Component.ComponentUser;
import First_Chapter.Bean.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    ComponentUser component;
    @GetMapping("/getComponent")
    public String getComponent() {
        return component.createComponent();
    }

    @Autowired
    Person person;
    @GetMapping("getBean")
    public String getBean() {
        return person.getName() + "  " + person.getAge();
    }
}
