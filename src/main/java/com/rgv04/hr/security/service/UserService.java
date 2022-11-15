package com.rgv04.hr.security.service;

import java.util.List;

import com.rgv04.hr.security.model.Role;
import com.rgv04.hr.security.model.User;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

    User getUserById(Long id);

}
