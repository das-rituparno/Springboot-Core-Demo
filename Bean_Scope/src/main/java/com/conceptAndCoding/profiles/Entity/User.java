package com.conceptAndCoding.profiles.Entity;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User {
    String name;
    String email;

    public User() {
        System.out.println("User initialization");
        System.out.println("User hashcode : " + this.hashCode());
    }
}
