package Second_Chapter.Dependency_Injection.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ComponentUser {
    public String createComponent() {
        return "Hello from Component";
    }

    @PostConstruct
    public void afterComponentCreation() {
        System.out.println("Component create ho gaya h!!!!");
    }
    @PreDestroy
    public void beforeComponentDestroy() {
        System.out.println("Component dabah hone se phele");
    }
}
