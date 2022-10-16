package com.rgv04.hr.controller.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Departament;
import com.rgv04.hr.model.dto.DepartamentDTO;

@Component
public class DepartamentAssembler implements Assembler<Departament, DepartamentDTO> {

    @Override
    public List<DepartamentDTO> toListModel(List<Departament> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DepartamentDTO toModel(Departament entity) {
        if (entity == null) {
            entity = new Departament();
        }
        return DepartamentDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .managerId(entity.getManagerId())
            .build();        
    }
    
}
