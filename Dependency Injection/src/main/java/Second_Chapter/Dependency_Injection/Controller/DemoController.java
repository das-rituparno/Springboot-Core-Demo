package Second_Chapter.Dependency_Injection.Controller;

import Second_Chapter.Dependency_Injection.Component.ComponentUser;
import Second_Chapter.Dependency_Injection.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @Autowired
    @Qualifier("one")
    Person person;
    @Autowired
    ComponentUser component;

    /*
    Injecting beans through a constructor.
    @Autowired
    public DemoController(ComponentUser component) {
        this.component = component;
    }

    Injecting beans through a setter method.
    @Autowired
    public void setComponent(ComponentUser component) {
        this.component = component;
    }
     */

    @GetMapping("/getComponent")
    public String getComponent() {
        return component.createComponent();
    }

    @GetMapping("getBean")
    public String getBean() {
        return person.getName() + "  " + person.getAge();
    }
}
