package com.concept.coding.jpa.Repo;

import com.concept.coding.jpa.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    List<UserDetails> findUserDetailsByNameStartingWith(String userName);

    @Query("SELECT u FROM UserDetails u WHERE u.name = :userFirstName")
    List<UserDetails> findByUserNameWithJPQL(@Param("userFirstName") String userName);

}
