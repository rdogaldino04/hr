package com.rgv04.hr.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import com.rgv04.hr.infrastructure.core.validation.FileContentType;
import com.rgv04.hr.infrastructure.core.validation.FileSize;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryImageInput {

	@NotNull
	@FileSize(max = "500KB")
	@FileContentType(allowed = { MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, "image/webp" })
	private MultipartFile file;

	@NotBlank
	private String description;

}
