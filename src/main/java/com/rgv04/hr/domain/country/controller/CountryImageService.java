package com.rgv04.hr.domain.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgv04.hr.domain.country.entity.CountryImage;
import com.rgv04.hr.domain.country.repository.CountryImageRepository;
import com.rgv04.hr.exception.BusinessException;

@Service
public class CountryImageService {

    @Autowired
    private CountryImageRepository countryImageRepository;

    public CountryImage findById(String countryId) {
        return countryImageRepository.findById(countryId)
                .orElseThrow(() -> new BusinessException(countryId));
    }

}
