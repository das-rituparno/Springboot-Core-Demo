package com.concept.coding.jpa.Service;

import com.concept.coding.jpa.Entity.UserDetails;
import com.concept.coding.jpa.Repo.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository repository;

    public UserDetails insertUser(UserDetails user) {
        return repository.save(user);
    }
}
