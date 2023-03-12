package com.rgv04.hr.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rgv04.hr.domain.dto.UserFilter;
import com.rgv04.hr.domain.model.User;
import com.rgv04.hr.domain.repository.UserRepositoryQueries;

@Repository
public class UserRepositoryImpl implements UserRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<User> getAll(UserFilter filter) {
		Map<String, Object> parameters = new HashMap<>();
		StringBuilder sql = new StringBuilder("select u from User u where 1=1 ");

		if (filter.getName() != null) {
			sql.append(" and u.name = :name ");
			parameters.put("name", filter.getName());
		}

		if (filter.getUsername() != null) {
			sql.append(" and u.username = :username ");
			parameters.put("username", filter.getUsername());
		}

		TypedQuery<User> typedQuery = manager.createQuery(sql.toString(), User.class)
				.setMaxResults(1000);
		parameters.forEach((key, value) -> {
			if (value != null) {
				typedQuery.setParameter(key, value);
			}
		});

		return typedQuery.getResultList();
	}

}
