package com.rgv04.hr.domain.country.repository;

import java.util.List;

import com.rgv04.hr.domain.country.CountryFilter;
import com.rgv04.hr.domain.country.entity.Country;

public interface CountryRepositoryQueries {

    List<Country> listByFilter(CountryFilter filter);

}
