package com.rgv04.hr.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgv04.hr.domain.model.Location;

public interface LocationRepository  extends JpaRepository<Location, Long>, LocationRepositoryQueries  {
	
}
