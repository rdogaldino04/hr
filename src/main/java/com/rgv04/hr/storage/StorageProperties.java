package com.rgv04.hr.storage;

import java.nio.file.Path;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("hr.storage")
public class StorageProperties {

    private Local local = new Local();

    public enum StorageType {		
		LOCAL		
	}

    @Getter
	@Setter
	public class Local {
		
		private Path directoryImages;
		
	}
    
}
