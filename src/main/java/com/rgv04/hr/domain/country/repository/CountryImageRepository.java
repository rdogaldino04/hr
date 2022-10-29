package com.rgv04.hr.domain.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgv04.hr.domain.country.entity.CountryImage;

@Repository
public interface CountryImageRepository extends JpaRepository<CountryImage, String> {

}
