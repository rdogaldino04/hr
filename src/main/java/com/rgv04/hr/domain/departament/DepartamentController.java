package com.rgv04.hr.domain.departament;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/departaments")
public class DepartamentController {

    private final DepartamentService departamentService;
    private final DepartamentAssembler departamentAssembler;

    // TODO: implement problem n + 1
    @GetMapping
    public ResponseEntity<CollectionModel<DepartamentModel>> findAll() {
        List<Departament> departaments = departamentService.findAll();
        CollectionModel<DepartamentModel> collectionModel = departamentAssembler.toCollectionModel(departaments);
        return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartamentModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(departamentAssembler.toModel(departamentService.findById(id)));
    }

}
