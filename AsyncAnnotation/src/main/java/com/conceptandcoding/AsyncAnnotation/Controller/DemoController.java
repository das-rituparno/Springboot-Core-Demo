package com.conceptandcoding.AsyncAnnotation.Controller;

import com.conceptandcoding.AsyncAnnotation.Async.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    ServiceClass sc;
    @GetMapping("/demo")
    public String getService() {
        System.out.println("inside controller method : " + Thread.currentThread().getName());
        sc.asyncMethod();
        return "SUCCESS";
    }
}
