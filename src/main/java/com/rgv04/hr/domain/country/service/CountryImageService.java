package com.rgv04.hr.domain.country.service;

import java.io.InputStream;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.country.CountryNotFoundException;
import com.rgv04.hr.domain.country.entity.CountryImage;
import com.rgv04.hr.domain.country.repository.CountryRepository;
import com.rgv04.hr.storage.StorageService;
import com.rgv04.hr.storage.StorageService.newImage;

@Service
public class CountryImageService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StorageService storageService;

    public CountryImage findById(String countryId) {
        return countryRepository.findImageById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));
    }

    @Transactional
    public CountryImage save(CountryImage countryImage, InputStream inputStream) {
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
        newImage novaFoto = newImage.builder()
                .fileName(countryImage.getFileName())
                .inputStream(inputStream)
                .build();

        storageService.replace(existingNameFile, novaFoto);
        return countryImage;
    }

    @Transactional
    public void deleteImage(String countryId) {
        CountryImage countryImage = this.findById(countryId);
        countryRepository.deleteImageById(countryImage.getId());
        countryRepository.flush();
        this.storageService.remove(countryImage.getFileName());
    }

}
