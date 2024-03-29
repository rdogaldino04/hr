package com.rgv04.hr.infrastructure.storage;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface StorageService {

	RecoveredImage recover(String fileName);

	void store(NewImage newImage);

	void remove(String fileName);

	default void replace(String fileNameOld, NewImage newImage) {
		this.store(newImage);
		if (fileNameOld != null) {
			this.remove(fileNameOld);
		}
	}

	default String generateFileName(String originalName) {
		return UUID.randomUUID().toString() + "_" + originalName;
	}

	@Builder
	@Getter
	class NewImage {

		private String fileName;
		private String contentType;
		private InputStream inputStream;

	}

	@Builder
	@Getter
	class RecoveredImage {

		private InputStream inputStream;
		private String url;

		public boolean hasUrl() {
			return url != null;
		}

		public boolean hasInputStream() {
			return inputStream != null;
		}

	}

}
