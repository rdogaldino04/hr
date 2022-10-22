package com.rgv04.hr.domain.location;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.rgv04.hr.domain.country.CountryModel;

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
@Relation(collectionRelation = "locations")
public class LocationModel extends RepresentationModel<LocationModel> {

	private Long id;

	private String streetAddress;

	private String postalCode;

	private String city;

	private String stateProvince;

	private CountryModel country;

}
