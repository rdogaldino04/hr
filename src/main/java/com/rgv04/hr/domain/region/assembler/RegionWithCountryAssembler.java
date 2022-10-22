package com.rgv04.hr.domain.region.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.rgv04.hr.domain.region.Region;
import com.rgv04.hr.domain.region.RegionController;
import com.rgv04.hr.domain.region.assembler.model.RegionWithCountryModel;

@Component
public class RegionWithCountryAssembler extends RepresentationModelAssemblerSupport<Region, RegionWithCountryModel> {

    @Autowired
    private ModelMapper modelMapper;

    public RegionWithCountryAssembler() {
        super(RegionController.class, RegionWithCountryModel.class);
    }

    @Override
    public RegionWithCountryModel toModel(Region entity) {
        RegionWithCountryModel regionWithCountryModel = createModelWithId(entity.getId(), entity);
        modelMapper.map(entity, regionWithCountryModel);
        return regionWithCountryModel;
    }

}
