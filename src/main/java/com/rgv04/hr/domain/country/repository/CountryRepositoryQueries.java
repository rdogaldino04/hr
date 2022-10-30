package com.rgv04.hr.domain.country.repository;

import java.util.List;

import com.rgv04.hr.domain.country.entity.Country;
import com.rgv04.hr.domain.country.entity.CountryImage;
import com.rgv04.hr.domain.country.entity.filter.CountryFilter;

public interface CountryRepositoryQueries {

    List<Country> listByFilter(CountryFilter filter);
    
    CountryImage saveImage(CountryImage countryImage);

    void deleteImageById(String countryId);

}
