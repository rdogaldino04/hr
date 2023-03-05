package com.rgv04.hr.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgv04.hr.domain.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
