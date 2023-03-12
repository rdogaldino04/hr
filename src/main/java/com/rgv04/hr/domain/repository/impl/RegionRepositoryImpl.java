package com.rgv04.hr.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.rgv04.hr.domain.dto.RegionFilter;
import com.rgv04.hr.domain.model.Region;
import com.rgv04.hr.domain.repository.RegionRepositoryQueries;

@Repository
public class RegionRepositoryImpl implements RegionRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> listByFilter(RegionFilter filter) {
		Map<String, Object> parametros = new HashMap<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT r FROM Region r WHERE 1=1 ");		
		if (filter.getRegionId() != null) {
			sql.append(" and r.id = :regionId ");
			parametros.put("regionId", filter.getRegionId());
		}
		if (StringUtils.hasText(filter.getRegionName())) {
			sql.append(" AND r.name LIKE :name ");
			parametros.put("name", filter.getRegionName().concat("%"));
		}		
		Query query = manager.createQuery(sql.toString());
		for (Map.Entry<String, Object> entry : parametros.entrySet()) {
			String key = entry.getKey();
			if (parametros.containsKey(key)) {
				query.setParameter(key, parametros.get(key));				
			}
		}
		return query.getResultList();
	}

}
