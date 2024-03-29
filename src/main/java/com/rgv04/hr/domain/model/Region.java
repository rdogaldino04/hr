package com.rgv04.hr.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "regions")
public class Region {

	@Id
	@Column(name = "REGION_ID")
	private Long id;

	@Column(name = "REGION_NAME")
	private String name;

	@OneToMany(mappedBy = "region")
	private List<Country> countries = new ArrayList<>();

}
