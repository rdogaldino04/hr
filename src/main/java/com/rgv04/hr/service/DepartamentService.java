package com.rgv04.hr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.model.Departament;
import com.rgv04.hr.repository.DepartamentRepository;
import com.rgv04.hr.service.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartamentService {

    private final DepartamentRepository departamentRepository;

    public List<Departament> findAll() {
        return this.departamentRepository.findAll();
    }

    public Departament findById(Long id) {
        return this.departamentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Entity not found"));
    }

}