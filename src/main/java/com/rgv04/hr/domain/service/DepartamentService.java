package com.rgv04.hr.domain.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.DepartamentAssembler;
import com.rgv04.hr.domain.dto.DepartamentModel;
import com.rgv04.hr.domain.exception.BusinessException;
import com.rgv04.hr.domain.repository.DepartamentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartamentService {

    private final DepartamentRepository departamentRepository;

    private final DepartamentAssembler departamentAssembler;

    public CollectionModel<DepartamentModel> getAll() {
        return departamentAssembler.toCollectionModel(this.departamentRepository.getAll());
    }

    public DepartamentModel getById(Long id) {
        return departamentAssembler.toModel(this.departamentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Entity not found")));
    }

}
