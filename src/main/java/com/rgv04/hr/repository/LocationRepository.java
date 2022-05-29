package com.rgv04.hr.repository;

import com.rgv04.hr.model.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>, LocationRepositoryQueries {
	
}
