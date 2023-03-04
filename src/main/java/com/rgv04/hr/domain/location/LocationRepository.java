package com.rgv04.hr.domain.location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location, Long>, LocationRepositoryQueries  {
	
}
