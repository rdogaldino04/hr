package com.rgv04.hr.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.rgv04.hr.domain.model.Country;
import com.rgv04.hr.domain.model.CountryImage;
import com.rgv04.hr.domain.model.Region;

public interface CountryRepository
		extends JpaRepository<Country, String>, JpaSpecificationExecutor<Country>, CountryRepositoryQueries {

	List<Country> findByRegion(Region region);

	@Query("select ci from CountryImage ci "+
			"join ci.country c " +
		" where c.id = :countryId")
    Optional<CountryImage> findImageById(String countryId);

}
