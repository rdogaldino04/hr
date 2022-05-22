package com.rgv04.hr.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rgv04.hr.model.Region;
import com.rgv04.hr.model.filter.RegionFilter;

@Repository
public class RegionRepositoryImpl implements RegionRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> listByFilter(RegionFilter filter) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DISTINCT r FROM Region r JOIN FETCH r.countries c WHERE 1=1 ");		
		if (filter.getRegionId() != null) {
			sql.append(" and r.id = :regionId ");
			parametros.put("regionId", filter.getRegionId());
		}
		if (filter.getRegionName() != null) {
			sql.append(" AND r.name LIKE :name ");
			parametros.put("name", filter.getRegionName().concat("%"));
		}
		if (filter.getCountryId() != null) {
			sql.append(" AND c.id = :countryId ");
			parametros.put("countryId", filter.getCountryId());
		}
		Query query = manager.createQuery(sql.toString());
		for (String key : parametros.keySet()) {
			if (parametros.containsKey(key)) {
				query.setParameter(key, parametros.get(key));				
			}
		}
		return query.getResultList();
	}

	@Override
	public Region byId(Long id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select r from Region r join fetch r.countries where r.id = :id");
		TypedQuery<Region> query = manager.createQuery(sql.toString(), Region.class)
				.setParameter("id", id);
		try {
			return query.getSingleResult();	
		} catch (Exception e) {
			return null;
		}		
		
	}

}
