package com.rgv04.hr.controller.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.model.Departament;
import com.rgv04.hr.model.dto.DepartamentDTO;

@Component
public class DepartamentAssembler implements Assembler<Departament, DepartamentDTO> {

    @Override
    public List<DepartamentDTO> toListDto(List<Departament> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DepartamentDTO toDto(Departament entity) {
        return DepartamentDTO.builder()
            .id(entity.getId())
            .name(entity.getName())
            .managerId(entity.getManagerId())
            .build();        
    }
    
}
