package com.rgv04.hr.domain.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rgv04.hr.domain.country.entity.Country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
