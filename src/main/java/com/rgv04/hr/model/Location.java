package com.rgv04.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private Long id;

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;
    
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    
}
