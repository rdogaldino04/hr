package com.rgv04.hr.domain.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.country.CountryNotFoundException;
import com.rgv04.hr.domain.country.entity.CountryImage;
import com.rgv04.hr.domain.country.repository.CountryImageRepository;

@Service
public class CountryImageService {

    @Autowired
    private CountryImageRepository countryImageRepository;

    public CountryImage findById(String countryId) {
        return countryImageRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));
    }

}
