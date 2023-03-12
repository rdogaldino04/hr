package com.rgv04.hr.domain.repository;

import java.util.List;

import com.rgv04.hr.domain.dto.UserFilter;
import com.rgv04.hr.domain.model.User;

public interface UserRepositoryQueries {

	List<User> getAll(UserFilter filter);

}
