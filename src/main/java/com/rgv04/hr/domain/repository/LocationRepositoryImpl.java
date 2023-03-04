package com.rgv04.hr.domain.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.rgv04.hr.domain.dto.LocationFilter;
import com.rgv04.hr.domain.model.Location;

@Repository
public class LocationRepositoryImpl implements LocationRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Location> ListByFilter(LocationFilter filter) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select l from Location l ")
				.append("join fetch l.country c ")
				.append("join fetch c.region r ")
				.append("where 1=1 ");

		if (filter.getLocationId() != null) {
			sql.append(" and l.id = :locationId ");
			parameters.put("locationId", filter.getLocationId());
		}

		if (StringUtils.hasText(filter.getStreetAddress())) {
			sql.append(" and lower(l.streetAddress) like lower((:streetAddress)) ");
			parameters.put("streetAddress", filter.getStreetAddress().concat("%"));
		}

		if (StringUtils.hasText(filter.getPostalCode())) {
			sql.append(" and lower(l.postalCode) like lower((:postalCode)) ");
			parameters.put("postalCode", filter.getPostalCode().concat("%"));
		}

		if (StringUtils.hasText(filter.getCity())) {
			sql.append(" and lower(l.city) like lower((:city)) ");
			parameters.put("city", filter.getCity().concat("%"));
		}

		if (StringUtils.hasText(filter.getStateProvince())) {
			sql.append(" and lower(l.stateProvince) like lower((:stateProvince)) ");
			parameters.put("stateProvince", filter.getStateProvince().concat("%"));
		}

		if (StringUtils.hasText(filter.getCountryId())) {
			sql.append(" and l.country.id = :countryId ");
			parameters.put("countryId", filter.getCountryId());
		}

		if (StringUtils.hasText(filter.getCountryName())) {
			sql.append(" and lower(l.country.name) like lower(:countryName) ");
			parameters.put("countryName", filter.getCountryName().concat("%"));
		}

		// @formatter:off
		TypedQuery<Location> createQuery = manager.createQuery(sql.toString(), Location.class);
		for (String key : parameters.keySet()) {
			if (parameters.containsKey(key)) {
				createQuery.setParameter(key, parameters.get(key));				
			}
		}
		// @formatter:on

		return createQuery.getResultList();
	}

}
