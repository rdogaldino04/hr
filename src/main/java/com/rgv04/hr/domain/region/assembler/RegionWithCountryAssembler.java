package com.rgv04.hr.domain.region.assembler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;
import com.rgv04.hr.domain.country.CountryAssembler;
import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.region.assembler.model.RegionWithCountryModel;

@Component
public class RegionWithCountryAssembler implements Assembler<Region, RegionWithCountryModel> {

    @Autowired
    private CountryAssembler countryAssembler;

    @Override
    public List<RegionWithCountryModel> toListModel(List<Region> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RegionWithCountryModel toModel(Region entity) {        
        RegionWithCountryModel model = new RegionWithCountryModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        if (!entity.getCountries().isEmpty()) {
            model.setCountries(countryAssembler.toListModel(entity.getCountries()));
        }
        return model;
    }

}
