package com.rgv04.hr.storage;

import java.io.InputStream;

import lombok.Builder;
import lombok.Getter;

public interface StorageService {

	RecoveredImage recover(String fileName);

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
