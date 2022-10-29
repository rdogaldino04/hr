package com.rgv04.hr.domain.country.controller;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgv04.hr.domain.country.entity.CountryImage;
import com.rgv04.hr.exception.EntityNotFoundException;
import com.rgv04.hr.storage.StorageService;
import com.rgv04.hr.storage.StorageService.RecoveredImage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/countries/{countryId}/image")
public class CountryImageController {

    private final StorageService countryStorageService;

    private final CountryImageService countryImageService;

    @GetMapping(produces = MediaType.ALL_VALUE)
    public ResponseEntity<?> getImage(@PathVariable String countryId, @RequestHeader(name = "accept") String acceptHeader)
            throws HttpMediaTypeNotAcceptableException {
        try {
            CountryImage countryImage = countryImageService.findById(countryId);
            MediaType mediaTypeImage = MediaType.parseMediaType(countryImage.getContentType());
            List<MediaType> mediaTypesAccepted = MediaType.parseMediaTypes(acceptHeader);
            checkCompatibilityMediaType(mediaTypeImage, mediaTypesAccepted);
            RecoveredImage recoveredImage = countryStorageService.recover(countryImage.getFileName());

            if (recoveredImage.hasUrl()) {
                // return ResponseEntity
                // .status(HttpStatus.FOUND)
                // .header(HttpHeaders.LOCATION, fotoRecuperada.getUrl())
                // .build();
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok()
                        .contentType(mediaTypeImage)
                        .body(new InputStreamResource(recoveredImage.getInputStream()));
            }            
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private void checkCompatibilityMediaType(MediaType mediaTypeImage,
            List<MediaType> mediaTypesAccepted) throws HttpMediaTypeNotAcceptableException {

        boolean compatible = mediaTypesAccepted.stream()
                .anyMatch(mediaTypeAceita -> mediaTypeAceita.isCompatibleWith(mediaTypeImage));

        if (!compatible) {
            throw new HttpMediaTypeNotAcceptableException(mediaTypesAccepted);
        }
    }

}
