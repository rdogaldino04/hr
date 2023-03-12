package com.rgv04.hr.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.rgv04.hr.domain.dto.CountryFilter;
import com.rgv04.hr.domain.model.Country;
import com.rgv04.hr.domain.model.CountryImage;
import com.rgv04.hr.domain.repository.CountryRepositoryQueries;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CountryRepositoryImpl implements CountryRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Country> listByFilter(CountryFilter filter) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sql = new StringBuilder("select c from Country c left join fetch c.region r  ")
                .append("where 1=1 ");

        if (StringUtils.hasText(filter.getId())) {
            sql.append(" and c.id = :id");
            parameters.put("id", filter.getId());
        }

        if (StringUtils.hasText(filter.getName())) {
            sql.append(" and c.name like :name");
            parameters.put("name", "%" + filter.getName() + "%");
        }

        if (filter.getRegionId() != null) {
            sql.append(" and c.region.id = :regionId");
            parameters.put("regionId", filter.getRegionId());
        }

        if (StringUtils.hasText(filter.getRegionName())) {
            sql.append(" and c.region.name like :regionName");
            parameters.put("regionName", "%" + filter.getRegionName() + "%");
        }

        TypedQuery<Country> createQuery = manager.createQuery(sql.toString(), Country.class);

        parameters.keySet().forEach(key -> {
            if (parameters.containsKey(key)) {
                createQuery.setParameter(key, parameters.get(key));
            }
        });
        return createQuery.getResultList();
    }

    @Override
    @Transactional
    public CountryImage saveImage(CountryImage countryImage) {
        return manager.merge(countryImage);
    }

    @Transactional
    @Override
    public void deleteImageById(String countryId) {
        StringBuilder sql = new StringBuilder("delete from CountryImage ci where ci.id = :countryId");
        int executeUpdate = manager.createQuery(sql.toString()).setParameter("countryId", countryId).executeUpdate();
        log.info("deleted images: {}", executeUpdate);
    }

}
