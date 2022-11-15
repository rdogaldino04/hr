package com.rgv04.hr.security.repository;

import org.springframework.stereotype.Repository;

import com.rgv04.hr.security.model.User;
import com.rgv04.hr.security.service.CustomJpaRepository;

@Repository
public interface UserRepository extends CustomJpaRepository<User, Long> {

    User findByUsername(String username);

}
