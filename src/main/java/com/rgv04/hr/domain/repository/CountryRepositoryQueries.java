package com.rgv04.hr.domain.repository;

import java.util.List;

import com.rgv04.hr.domain.dto.CountryFilter;
import com.rgv04.hr.domain.model.Country;
import com.rgv04.hr.domain.model.CountryImage;

public interface CountryRepositoryQueries {

    List<Country> listByFilter(CountryFilter filter);
    
    CountryImage saveImage(CountryImage countryImage);

    void deleteImageById(String countryId);

}
