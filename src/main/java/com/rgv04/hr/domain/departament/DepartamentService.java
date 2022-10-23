package com.rgv04.hr.domain.departament;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rgv04.hr.exception.BusinessException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DepartamentService {

    private final DepartamentRepository departamentRepository;

    public List<Departament> getAll() {
        return this.departamentRepository.getAll();
    }

    public Departament getById(Long id) {
        return this.departamentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Entity not found"));
    }

}
