package com.rgv04.hr.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rgv04.hr.domain.model.Departament;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {

    @Query("select d from Departament d " +
            "left join fetch d.location l " +
            "left join fetch l.country c " +
            "left join fetch c.region r ")
    List<Departament> getAll();

}
