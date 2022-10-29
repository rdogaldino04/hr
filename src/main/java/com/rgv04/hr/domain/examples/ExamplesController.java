package com.rgv04.hr.domain.examples;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExamplesController {

    @GetMapping("/api/examples/request-param-list")
    public ResponseEntity<List<Long>> parametersListRequestParam(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(ids);
    }

    @GetMapping("/api/examples/path-variable-list/{ids}")
    public ResponseEntity<List<Long>> parametersListPathvariable(@PathVariable List<Long> ids) {
        return ResponseEntity.ok(ids);
    }

    @PutMapping("/api/examples/img")
    public ResponseEntity<?> img(Boolean jpg, String descFile, @RequestPart(required = true) MultipartFile mFile)
            throws IOException {
        System.out.println(mFile.getContentType());
        MediaType contentType = jpg ? MediaType.IMAGE_JPEG : MediaType.IMAGE_PNG;
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(new InputStreamResource(mFile.getInputStream()));
    }

}
