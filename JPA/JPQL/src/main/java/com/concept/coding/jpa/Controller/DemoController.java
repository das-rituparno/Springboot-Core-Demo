package com.concept.coding.jpa.Controller;

import com.concept.coding.jpa.Entity.UserDetails;
import com.concept.coding.jpa.Repo.UserDetailsRepository;
import com.concept.coding.jpa.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {

    @Autowired
    UserDetailsService service;

    @GetMapping("/test/{name}")
    public List<UserDetails> findUsersByName(@PathVariable String name) {
        return service.findByNameDerived(name);
    }

    @PostMapping("/add")
    public UserDetails addNewUser(@RequestBody UserDetails user) {
        return service.insertUser(user);
    }

    @GetMapping("/jpql")
    public List<UserDetails> getUsersByJPQL(@RequestParam String name) {
        return service.findByNameJPQL(name);
    }
}
