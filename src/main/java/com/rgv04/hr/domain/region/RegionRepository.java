package com.rgv04.hr.domain.region;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryQueries {

	List<Region> findAll();

	@Query("select r from Region r left join fetch r.countries c where r.id = :regionId")
	Optional<Region> countriesByRegionId(Long regionId);

}
