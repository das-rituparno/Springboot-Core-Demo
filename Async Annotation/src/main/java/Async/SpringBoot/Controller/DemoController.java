package Async.SpringBoot.Controller;

import Async.SpringBoot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    UserService service;
    @GetMapping("/check")
    public String getUserMethod() {
        System.out.println("Inside get user method " + Thread.currentThread().getName());
        service.asyncMethodTest();
        return null;
    }
}
