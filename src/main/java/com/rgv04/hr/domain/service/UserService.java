package com.rgv04.hr.domain.service;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;

import com.rgv04.hr.domain.dto.RoleDTO;
import com.rgv04.hr.domain.dto.UserFilter;
import com.rgv04.hr.domain.dto.UserModel;
import com.rgv04.hr.domain.model.User;

public interface UserService {

	User save(User user);

	RoleDTO saveRole(RoleDTO roleDTO);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	CollectionModel<UserModel> getUsers();

	User getUserById(Long id);

	CollectionModel<UserModel> findAllPaginatedUsers(UserFilter userFilter, Pageable pageable);

}
