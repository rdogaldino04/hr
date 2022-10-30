package com.rgv04.hr.domain.region.assembler.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.server.core.Relation;

import com.rgv04.hr.domain.country.controller.model.CountryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "regions-with-countries")
public class RegionWithCountryModel extends RegionModel {

    private List<CountryModel> countries = new ArrayList<CountryModel>();

}
