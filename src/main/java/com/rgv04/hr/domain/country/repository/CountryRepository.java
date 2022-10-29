package com.rgv04.hr.domain.country.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.domain.country.entity.Country;
import com.rgv04.hr.domain.region.Region;

@Repository
public interface CountryRepository
		extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country>, CountryRepositoryQueries {

	List<Country> findByRegion(Region region);

}
