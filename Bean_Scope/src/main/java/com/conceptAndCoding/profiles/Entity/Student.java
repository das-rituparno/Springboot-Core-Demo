package com.conceptAndCoding.profiles.Entity;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    @Autowired
    User user;

    public Student() {
        System.out.println("Student instance initialization");
    }
    @PostConstruct
    public void init() {
        System.out.println("Student object hashcode : " + this.hashCode());
        System.out.println("User object hashcode : " + user.hashCode());
    }
}
