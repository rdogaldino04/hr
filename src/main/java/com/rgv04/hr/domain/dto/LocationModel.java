package com.rgv04.hr.domain.dto;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "locations")
public class LocationModel extends RepresentationModel<LocationModel> {

	@EqualsAndHashCode.Include
	private Long id;

	private String streetAddress;

	private String postalCode;

	private String city;

	private String stateProvince;

	private CountryModel country;

}
