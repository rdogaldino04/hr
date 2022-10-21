package com.rgv04.hr.domain.country;

import com.rgv04.hr.domain.region.RegionModel;

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
public class CountryModel {

	private String id;

	private String name;

	private RegionModel region;

}
