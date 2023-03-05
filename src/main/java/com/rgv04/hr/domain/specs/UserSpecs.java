package com.rgv04.hr.domain.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.rgv04.hr.domain.dto.UserFilter;
import com.rgv04.hr.domain.model.User;

public class UserSpecs {

    private UserSpecs() {}

    public static Specification<User> usingFilter(UserFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(filter.getName())) {
                predicates.add(builder.like(root.get("name"), filter.getName().concat("%")));
            }
            if (StringUtils.hasText(filter.getUsername())) {
                predicates.add(builder.like(root.get("username"), filter.getUsername().concat("%")));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
