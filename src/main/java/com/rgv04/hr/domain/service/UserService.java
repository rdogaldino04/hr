package com.rgv04.hr.domain.service;

import java.util.List;

import com.rgv04.hr.domain.dto.RoleDTO;
import com.rgv04.hr.domain.model.User;

public interface UserService {

	User save(User user);

	RoleDTO saveRole(RoleDTO roleDTO);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	List<User> getUsers();

	User getUserById(Long id);

}
