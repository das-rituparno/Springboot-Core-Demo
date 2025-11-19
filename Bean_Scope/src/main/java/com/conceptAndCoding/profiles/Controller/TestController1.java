package com.conceptAndCoding.profiles.Controller;

import com.conceptAndCoding.profiles.Entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope(value = "request")
public class TestController1 {
    @Autowired
    User user;
    public TestController1() {
        System.out.println("Test-controller-1 instance initialization");
    }
    @PostConstruct
    public void init() {
        System.out.println("Test-controller-1 hashcode : " + this.hashCode()
                + ",   " + "User hashcode : " + user.hashCode());
    }
    @GetMapping("/fetch1")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("user 1 api invoked.");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletRequest req) {
        System.out.println("end the session");
        HttpSession session = req.getSession();
        session.invalidate();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
