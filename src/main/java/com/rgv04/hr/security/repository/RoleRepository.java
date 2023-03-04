package com.rgv04.hr.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgv04.hr.security.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
