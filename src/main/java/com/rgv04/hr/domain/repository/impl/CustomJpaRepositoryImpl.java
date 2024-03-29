package com.rgv04.hr.domain.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.rgv04.hr.domain.repository.CustomJpaRepository;

public class CustomJpaRepositoryImpl<T, I> extends SimpleJpaRepository<T, I> implements CustomJpaRepository<T, I> {

    private EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.manager = entityManager;
    }

    @Override
    public Optional<T> getTheFirstRecord() {
        String jpql = "from " + getDomainClass().getName();
        T entity = manager.createQuery(
                jpql, getDomainClass()).setMaxResults(1)
                .getSingleResult();
        return Optional.ofNullable(entity);
    }

    @Override
    public void detach(T entity) {
        manager.detach(entity);
    }

}
