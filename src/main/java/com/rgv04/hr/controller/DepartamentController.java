package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.departament.Departament;
import com.rgv04.hr.domain.departament.DepartamentAssembler;
import com.rgv04.hr.domain.departament.DepartamentModel;
import com.rgv04.hr.domain.departament.DepartamentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/departaments")
public class DepartamentController {

    private final DepartamentService departamentService;
    private final DepartamentAssembler departamentAssembler;

    @GetMapping
    public ResponseEntity<CollectionModel<DepartamentModel>> getAll() {
        List<Departament> departaments = departamentService.getAll();
        CollectionModel<DepartamentModel> collectionModel = departamentAssembler.toCollectionModel(departaments);
        return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartamentModel> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departamentAssembler.toModel(departamentService.getById(id)));
    }

}
