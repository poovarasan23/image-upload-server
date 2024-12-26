package com.bt.image_upload.service;

import com.bt.image_upload.entity.ImageUpload;
import com.bt.image_upload.repository.ImageUploadRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ImageUploadService {
    @Autowired
    private ImageUploadRepository imageRepository;

    public List<ImageUpload> getAllImages() {
        return imageRepository.findAll();
    }

    public Optional<ImageUpload> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    public ImageUpload saveImage(ImageUpload image) {
        return imageRepository.save(image);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public void saveImagesFromExcel() throws IOException {
        List<ImageUpload> images = new ArrayList<>();
        File svgFile=new File("src/main/resources/testData/bt_american_football.svg");
        byte[] svgBytes = new byte[(int) svgFile.length()];
        ImageUpload image = new ImageUpload();
        image.setImageName("bt_american_football.svg");
        image.setImageBrand("BT");
        image.setImageData(svgBytes);
        images.add(image);
        imageRepository.saveAll(images);
    }
}
