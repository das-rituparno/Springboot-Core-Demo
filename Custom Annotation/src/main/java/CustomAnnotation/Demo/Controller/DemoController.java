package CustomAnnotation.Demo.Controller;

import CustomAnnotation.Demo.Service.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    ServiceDemo service;

    @GetMapping("/getuser")
    public String getUser() {
        service.testMethod();
        return "SUCCESS";
    }
}
