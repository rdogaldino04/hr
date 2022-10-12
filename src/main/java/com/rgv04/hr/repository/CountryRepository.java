package com.rgv04.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.model.Country;
import com.rgv04.hr.model.Region;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country> {

	@Query("select c from Country c join fetch c.region r")
	List<Country> findAll();
	
	List<Country> findByRegion(Region region);

}
