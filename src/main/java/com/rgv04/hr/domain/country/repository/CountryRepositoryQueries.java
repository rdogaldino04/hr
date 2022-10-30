package com.rgv04.hr.domain.country.repository;

import java.util.List;

import com.rgv04.hr.domain.country.CountryFilter;
import com.rgv04.hr.domain.country.entity.Country;
import com.rgv04.hr.domain.country.entity.CountryImage;

public interface CountryRepositoryQueries {

    List<Country> listByFilter(CountryFilter filter);
    
    CountryImage saveImage(CountryImage countryImage);

    void deleteImageById(String countryId);

}
