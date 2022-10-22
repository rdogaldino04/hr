package com.rgv04.hr.domain.departament;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.country.Country;
import com.rgv04.hr.domain.country.CountryModel;
import com.rgv04.hr.domain.location.Location;
import com.rgv04.hr.domain.location.LocationModel;
import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.region.assembler.model.RegionModel;

@Component
public class DepartamentAssembler implements Assembler<Departament, DepartamentModel> {

    @Override
    public List<DepartamentModel> toListModel(List<Departament> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DepartamentModel toModel(Departament entity) {
        if (entity == null) {
            entity = new Departament();
        }
        if (entity.getLocation() == null) {
            entity.setLocation(new Location());
        }
        if (entity.getLocation().getCountry() == null) {
            entity.getLocation().setCountry(new Country());
        }
        if (entity.getLocation().getCountry().getRegion() == null) {
            entity.getLocation().getCountry().setRegion(new Region());
        }
        return DepartamentModel.builder()
            .id(entity.getId())
            .name(entity.getName())
            .managerId(entity.getManagerId())
            .location(LocationModel.builder()
                .id(entity.getLocation().getId())
                .streetAddress(entity.getLocation().getStreetAddress())
                .postalCode(entity.getLocation().getPostalCode())
                .city(entity.getLocation().getCity())
                .stateProvince(entity.getLocation().getStateProvince())
                .country(CountryModel.builder()
                    .id(entity.getLocation().getCountry().getId())
                    .name(entity.getLocation().getCountry().getName())
                    .region(RegionModel.builder()
                        .id(entity.getLocation().getCountry().getRegion().getId())
                        .name(entity.getLocation().getCountry().getRegion().getName())
                        .build())
                    .build())
                .build())
            .build();        
    }
    
}
