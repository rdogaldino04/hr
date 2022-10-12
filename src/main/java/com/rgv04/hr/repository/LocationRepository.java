package com.rgv04.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.model.Location;

@Repository
public interface LocationRepository  extends JpaRepository<Location, Long>, LocationRepositoryQueries  {
	
}
