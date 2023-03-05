package com.rgv04.hr.domain.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.rgv04.hr.domain.dto.JobFilter;
import com.rgv04.hr.domain.model.Job;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobSpecs {

    private JobSpecs() {}
    
    public static Specification<Job> getSpecs(JobFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            log.info(filter.toString());
            if (StringUtils.hasText(filter.getJobId())) {
                predicates.add(builder.equal(root.get("id"), filter.getJobId()));
            }
            if (StringUtils.hasText(filter.getTitle())) {
                predicates.add(builder.like(root.get("title"), filter.getTitle().concat("%")));
            }
            if (filter.getMaxSalary() != null) {
                predicates.add(builder.equal(root.get("maxSalary"), filter.getMaxSalary()));
            }
            if (filter.getMinSalary() != null) {
                predicates.add(builder.equal(root.get("minSalary"), filter.getMinSalary()));
            }
            if (filter.getMinSalaryGreaterThan() != null) {
                predicates.add(builder.greaterThan(root.get("minSalary"), filter.getMinSalaryGreaterThan()));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
    
}
