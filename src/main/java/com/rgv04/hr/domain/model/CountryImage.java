package com.rgv04.hr.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CountryImage {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "COUNTRY_ID")
    private String id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId(value = "COUNTRY_ID")
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    private String fileName;

    private String description;

    private String contentType;

    private Long size;

}
