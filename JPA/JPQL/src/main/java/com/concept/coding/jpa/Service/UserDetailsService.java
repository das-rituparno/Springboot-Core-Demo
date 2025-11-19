package com.concept.coding.jpa.Service;

import com.concept.coding.jpa.Entity.UserDetails;
import com.concept.coding.jpa.Repo.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsRepository repository;

    public UserDetails insertUser(UserDetails user) {
        return repository.save(user);
    }

    public List<UserDetails> findByNameDerived(String name) {
        return repository.findUserDetailsByNameStartingWith(name);
    }

    public List<UserDetails> findByNameJPQL(String name) {
        return repository.findByUserNameWithJPQL(name);
    }
    
}
