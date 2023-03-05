package com.rgv04.hr.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomJpaRepository<T, I> extends JpaRepository<T, I> {

    Optional<T> getTheFirstRecord();

    void detach(T entity);

}
