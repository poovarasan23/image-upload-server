package com.bt.image_upload.controller;

import com.bt.image_upload.entity.ImageUpload;
import com.bt.image_upload.service.ImageUploadService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageUploadController {
    @Autowired
    private ImageUploadService imageService;

    @GetMapping
    public List<ImageUpload> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageUpload> getImageById(@PathVariable Long id) {
        Optional<ImageUpload> image = imageService.getImageById(id);
        return image.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ImageUpload createImage(@RequestBody ImageUpload imageUpload) throws IOException {
        ImageUpload image = new ImageUpload();
        image.setImageName(imageUpload.getImageName());
        image.setImageBrand(imageUpload.getImageBrand());
        image.setImageData(Base64.getDecoder().decode(imageUpload.getImageData()));
        return imageService.saveImage(image);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageUpload> updateImage(@PathVariable Long id, @ModelAttribute ImageUpload imageUpload) throws IOException {
        Optional<ImageUpload> image = imageService.getImageById(id);
        if (image.isPresent()) {
            ImageUpload updatedImage = image.get();
            updatedImage.setImageName(imageUpload.getImageName());
            updatedImage.setImageBrand(imageUpload.getImageBrand());
            updatedImage.setImageData(Base64.getDecoder().decode(imageUpload.getImageData()));
            return ResponseEntity.ok(imageService.saveImage(updatedImage));
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadExcel() throws IOException, InvalidFormatException {
        imageService.saveImagesFromExcel();
        return ResponseEntity.ok().build();
    }
}
