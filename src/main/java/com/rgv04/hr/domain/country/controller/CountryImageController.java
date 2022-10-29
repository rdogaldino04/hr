package com.rgv04.hr.domain.country.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.exception.BusinessException;
import com.rgv04.hr.exception.EntityNotFoundException;
import com.rgv04.hr.storage.StorageService;
import com.rgv04.hr.storage.StorageService.RecoveredImage;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/countries/{countryId}/image")
public class CountryImageController {

    private final StorageService countryStorageService;

    @GetMapping(produces = MediaType.ALL_VALUE)
    public ResponseEntity<?> getImage(@PathVariable Long countryId, @RequestHeader(name = "accept") String acceptHeader)
            throws HttpMediaTypeNotAcceptableException {
        try {
            //FotoProduto fotoProduto = catalogoFotoProduto.buscarOuFalhar(restauranteId, produtoId);

            //MediaType mediaTypeFoto = MediaType.parseMediaType(fotoProduto.getContentType());
            //List<MediaType> mediaTypesAceitas = MediaType.parseMediaTypes(acceptHeader);

            //verificarCompatibilidadeMediaType(mediaTypeFoto, mediaTypesAceitas);

            RecoveredImage recoveredImage = countryStorageService.recover("imperio.jpg"/*fotoProduto.getNomeArquivo()*/);

            if (recoveredImage.hasUrl()) {
            //     return ResponseEntity
            //             .status(HttpStatus.FOUND)
            //             .header(HttpHeaders.LOCATION, fotoRecuperada.getUrl())
            //             .build();
            } else {
                 return ResponseEntity.ok()
                         .contentType(MediaType.IMAGE_PNG)
                         .body(new InputStreamResource(recoveredImage.getInputStream()));
            }
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    
}
