package com.conceptAndCoding.profiles.Controller;

import com.conceptAndCoding.profiles.Entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {
    @Autowired
    User user;
    public TestController2() {
        System.out.println("Test-controller-2 instance initialization");
    }
    @PostConstruct
    public void init() {
        System.out.println("Test-controller-2 hashcode : " + this.hashCode()
                + ",   " + "User hashcode : " + user.hashCode());
    }
    @GetMapping("/fetch2")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("user 2 api invoked.");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
