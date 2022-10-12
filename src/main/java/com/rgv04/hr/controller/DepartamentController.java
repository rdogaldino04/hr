package com.rgv04.hr.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.model.Departament;
import com.rgv04.hr.service.DepartamentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("departaments")
public class DepartamentController {

    private final DepartamentService departamentService;

    @GetMapping
    public ResponseEntity<List<Departament>> findAll() {
        return ResponseEntity.ok(departamentService.findAll());
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Departament> findById(@PathVariable Long id) {
        return ResponseEntity.ok(departamentService.findById(id));
    }

}
