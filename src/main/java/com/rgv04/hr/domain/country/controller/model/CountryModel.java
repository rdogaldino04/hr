package com.rgv04.hr.domain.country.controller.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.rgv04.hr.domain.region.assembler.model.RegionModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Relation(collectionRelation = "countries")
public class CountryModel extends RepresentationModel<RegionModel> {

	private String id;

	private String name;

	private RegionModel region;

}
