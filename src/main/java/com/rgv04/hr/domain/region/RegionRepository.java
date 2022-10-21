package com.rgv04.hr.domain.region;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryQueries {

	List<Region> findAll();

}
