package com.rgv04.hr.model.filter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegionFilter {

	private Long regionId;

	private String regionName;

	private String countryId;

	private String countryName;

	public RegionFilter(Long regionId, String countryId) {
		this.regionId = regionId;
		this.countryId = countryId;
	}

}
