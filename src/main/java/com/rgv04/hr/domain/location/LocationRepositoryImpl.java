package com.rgv04.hr.domain.location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class LocationRepositoryImpl implements LocationRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Location> ListByFilter(LocationFilter filter) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select l from Location l ")
				.append("join fetch l.country c ")
				.append("join fetch c.region r ")
				.append("where 1=1 ");

		if (filter.getLocationId() != null) {
			sql.append(" and l.id = :locationId ");
			parametros.put("locationId", filter.getLocationId());
		}

		if (StringUtils.hasText(filter.getStreetAddress())) {
			sql.append(" and lower(l.streetAddress) like lower((:streetAddress)) ");
			parametros.put("streetAddress", filter.getStreetAddress().concat("%"));
		}

		if (StringUtils.hasText(filter.getPostalCode())) {
			sql.append(" and lower(l.postalCode) like lower((:postalCode)) ");
			parametros.put("postalCode", filter.getPostalCode().concat("%"));
		}

		if (StringUtils.hasText(filter.getCity())) {
			sql.append(" and lower(l.city) like lower((:city)) ");
			parametros.put("city", filter.getCity().concat("%"));
		}

		if (StringUtils.hasText(filter.getStateProvince())) {
			sql.append(" and lower(l.stateProvince) like lower((:stateProvince)) ");
			parametros.put("stateProvince", filter.getStateProvince().concat("%"));
		}

		if (StringUtils.hasText(filter.getCountryId())) {
			sql.append(" and l.country.id = :countryId ");
			parametros.put("countryId", filter.getCountryId());
		}

		if (StringUtils.hasText(filter.getCountryName())) {
			sql.append(" and lower(l.country.name) like lower(:countryName) ");
			parametros.put("countryName", filter.getCountryName().concat("%"));
		}

		// @formatter:off
		TypedQuery<Location> createQuery = manager.createQuery(sql.toString(), Location.class);
		for (String key : parametros.keySet()) {
			if (parametros.containsKey(key)) {
				createQuery.setParameter(key, parametros.get(key));				
			}
		}
		// @formatter:on

		return createQuery.getResultList();
	}

}
