package com.rgv04.hr.domain.service;

import java.io.InputStream;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.assembler.CountryImageAssembler;
import com.rgv04.hr.domain.assembler.CountryImageDisassembler;
import com.rgv04.hr.domain.dto.CountryImageModel;
import com.rgv04.hr.domain.exception.EntityNotFoundException;
import com.rgv04.hr.domain.model.Country;
import com.rgv04.hr.domain.model.CountryImage;
import com.rgv04.hr.domain.repository.CountryRepository;
import com.rgv04.hr.infrastructure.storage.StorageService;
import com.rgv04.hr.infrastructure.storage.StorageService.NewImage;

@Service
public class CountryImageService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryImageAssembler countryImageAssembler;

    @Autowired
    private CountryImageDisassembler countryImageDisassembler;

    public CountryImageModel findById(String countryId) {
        return countryImageAssembler.toModel(countryRepository.findImageById(countryId)
                .orElseThrow(() -> new EntityNotFoundException(countryId)));
    }

    @Transactional
    public CountryImageModel save(CountryImageModel countryImageModel, InputStream inputStream) {
        Country country = countryService.findById(countryImageModel.getId());
        CountryImage countryImage = this.countryImageDisassembler.toDomainObject(countryImageModel);
        countryImage.setCountry(country);
        String countryId = countryImage.getId();
        String fileNameNew = storageService.generateFileName(countryImage.getFileName());
        String existingNameFile = null;
        Optional<CountryImage> countryImageExisting = countryRepository.findImageById(countryId);
        if (countryImageExisting.isPresent()) {
            existingNameFile = countryImageExisting.get().getFileName();
        }
        countryImage.setFileName(fileNameNew);
        countryImage = countryRepository.saveImage(countryImage);
        countryRepository.flush();
        NewImage novaFoto = NewImage.builder()
                .fileName(countryImage.getFileName())
                .inputStream(inputStream)
                .build();

        storageService.replace(existingNameFile, novaFoto);
        return this.countryImageAssembler.toModel(countryImage);
    }

    @Transactional
    public void deleteImage(String countryId) {
        CountryImage countryImage = countryRepository.findImageById(countryId)
                .orElseThrow(() -> new EntityNotFoundException(countryId));
        countryRepository.deleteImageById(countryImage.getId());
        countryRepository.flush();
        this.storageService.remove(countryImage.getFileName());
    }

}
