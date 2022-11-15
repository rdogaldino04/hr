package com.rgv04.hr.security.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rgv04.hr.security.model.User;
import com.rgv04.hr.security.service.CustomJpaRepository;

@Repository
public interface UserRepository extends CustomJpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
