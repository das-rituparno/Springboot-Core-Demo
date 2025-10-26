package CustomAnnotation.Demo.Service;

import CustomAnnotation.Demo.Annotation.MyCustomAnnotation;
import org.springframework.stereotype.Component;

@Component
public class ServiceDemo {
    @MyCustomAnnotation(name = "custom-Method")
    public void testMethod() {
        System.out.println("ACTUAL CODE");
    }
}
