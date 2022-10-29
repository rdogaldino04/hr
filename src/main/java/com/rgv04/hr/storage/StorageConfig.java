package com.rgv04.hr.storage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Bean
    public StorageService storageService() {
        return new LocalImageStorageService();
    }

}
