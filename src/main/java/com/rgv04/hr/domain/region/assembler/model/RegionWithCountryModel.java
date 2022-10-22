package com.rgv04.hr.domain.region.assembler.model;

import java.util.ArrayList;
import java.util.List;

import com.rgv04.hr.domain.country.CountryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionWithCountryModel extends RegionModel {

    private List<CountryModel> countries = new ArrayList<CountryModel>();

}
