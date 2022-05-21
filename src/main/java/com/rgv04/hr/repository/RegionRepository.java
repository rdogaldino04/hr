package com.rgv04.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryQueries {

	List<Region> findAll();

}
