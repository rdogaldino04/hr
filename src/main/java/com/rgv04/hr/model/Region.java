package com.rgv04.hr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "regions", schema = "hr")
public class Region {

	@Id
	@Column(name = "REGION_ID")
	private Long id;

	@Column(name = "REGION_NAME")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "region", cascade = CascadeType.ALL, targetEntity = Country.class, fetch = FetchType.LAZY)
	private List<Country> countries = new ArrayList<>();

}
