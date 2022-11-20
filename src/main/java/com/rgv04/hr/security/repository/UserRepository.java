package com.rgv04.hr.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.security.model.User;
import com.rgv04.hr.security.service.CustomJpaRepository;

@Repository
public interface UserRepository extends CustomJpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query("select u from User u")
    List<User> getAll();

    @Query("select u from User u join fetch Role r")
    List<User> findAll();

}
