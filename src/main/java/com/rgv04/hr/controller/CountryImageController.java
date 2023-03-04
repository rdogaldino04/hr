package com.rgv04.hr.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rgv04.hr.domain.dto.CountryImageInput;
import com.rgv04.hr.domain.dto.CountryImageModel;
import com.rgv04.hr.domain.service.CountryImageService;
import com.rgv04.hr.exception.EntityNotFoundException;
import com.rgv04.hr.storage.StorageService;
import com.rgv04.hr.storage.StorageService.RecoveredImage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/countries/{countryId}/images")
public class CountryImageController {

    private final StorageService countryStorageService;

    private final CountryImageService countryImageService;

    @GetMapping(produces = MediaType.ALL_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String countryId, @RequestHeader(name = "accept") String acceptHeader)
            throws HttpMediaTypeNotAcceptableException {
        try {
            CountryImageModel countryImageModel = countryImageService.findById(countryId);
            MediaType mediaTypeImage = MediaType.parseMediaType(countryImageModel.getContentType());
            List<MediaType> mediaTypesAccepted = MediaType.parseMediaTypes(acceptHeader);
            checkCompatibilityMediaType(mediaTypeImage, mediaTypesAccepted);
            RecoveredImage recoveredImage = countryStorageService.recover(countryImageModel.getFileName());

            if (recoveredImage.hasUrl()) {
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/info")
    public ResponseEntity<CountryImageModel> getImageInfomation(@PathVariable String countryId) {
        CountryImageModel countryImageModel = countryImageService.findById(countryId);
        return ResponseEntity.ok(countryImageModel);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CountryImageModel> updateImg(@PathVariable String countryId, @Valid CountryImageInput input,
            @RequestPart(required = true) MultipartFile file)
            throws IOException {

        CountryImageModel countryImageModel = CountryImageModel.builder()
                .id(countryId)
                .contentType(file.getContentType())
                .description(input.getDescription())
                .size(file.getSize())
                .fileName(file.getOriginalFilename())
                .build();

        CountryImageModel countrySave = countryImageService.save(countryImageModel, file.getInputStream());
        return ResponseEntity.ok(countrySave);
    }

    @DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteImage(@PathVariable String countryId) {
		this.countryImageService.deleteImage(countryId);
	}
	    
}
