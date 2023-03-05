package com.rgv04.hr.api.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.dto.DepartamentModel;
import com.rgv04.hr.domain.service.DepartamentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/departaments")
public class DepartamentController {

    private final DepartamentService departamentService;

    @GetMapping
    public ResponseEntity<CollectionModel<DepartamentModel>> getAll() {
        return ResponseEntity.ok(departamentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartamentModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departamentService.getById(id));
    }

}
