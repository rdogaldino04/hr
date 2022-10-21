package com.rgv04.hr.domain.departament;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rgv04.hr.assembler.Assembler;

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
        return DepartamentModel.builder()
            .id(entity.getId())
            .name(entity.getName())
            .managerId(entity.getManagerId())
            .build();        
    }
    
}
