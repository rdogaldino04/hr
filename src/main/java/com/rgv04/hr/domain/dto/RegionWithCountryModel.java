package com.rgv04.hr.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.server.core.Relation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "regions-with-countries")
public class RegionWithCountryModel extends RegionModel {

    private List<CountryModel> countries = new ArrayList<>();

}
