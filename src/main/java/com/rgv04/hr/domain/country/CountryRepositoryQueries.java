package com.rgv04.hr.domain.country;

import java.util.List;

public interface CountryRepositoryQueries {

    List<Country> listByFilter(CountryFilter filter);

}
