package com.rgv04.hr.domain.country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rgv04.hr.domain.region.Region;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
@Table(name = "countries")
public class Country {

	@Id
	@Column(name = "COUNTRY_ID")
	private String id;

	@Column(name = "COUNTRY_NAME")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REGION_ID")
	private Region region;

}