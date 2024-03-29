package com.rgv04.hr.domain.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.rgv04.hr.domain.dto.CountryFilter;
import com.rgv04.hr.domain.model.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountrySpecs {

    private CountrySpecs() {}

    public static Specification<Country> getSpecs(CountryFilter countryFilter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            log.info(countryFilter.toString());
            if (countryFilter.getId() != null) {
                predicates.add(builder.equal(root.get("id"), countryFilter.getId()));
            }
            if (StringUtils.hasText(countryFilter.getName())) {
                predicates.add(builder.like(root.get("name"), countryFilter.getName().concat("%")));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
