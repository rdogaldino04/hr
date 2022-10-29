package com.rgv04.hr.storage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;

public class LocalImageStorageService implements StorageService {

    @Autowired
	private StorageProperties storageProperties;

    @Override
    public RecoveredImage recover(String fileName) {
        try {
            Path pathFile = getFilePath(fileName);
            RecoveredImage recoveredImage = RecoveredImage.builder()
                    .inputStream(Files.newInputStream(pathFile))
                    .build();

            return recoveredImage;
        } catch (Exception e) {
            throw new StorageException("Could not recover file.", e);
        }
    }

    private Path getFilePath(String fileName) {
		return storageProperties.getLocal().getDirectoryImages()
				.resolve(Paths.get(fileName));
	}
    
}
