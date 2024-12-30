package com.bt.image_upload.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageName;
    private String imageBrand;

    @Lob
    private byte[] imageData;

//    public ImageUpload() {
//    }
//
//    public ImageUpload(Long id, String imageName, String imageBrand, byte[] imageData) {
//        this.id = id;
//        this.imageName = imageName;
//        this.imageBrand = imageBrand;
//        this.imageData = imageData;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getImageName() {
//        return imageName;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//
//    public String getImageBrand() {
//        return imageBrand;
//    }
//
//    public void setImageBrand(String imageBrand) {
//        this.imageBrand = imageBrand;
//    }
//
//    public byte[] getImageData() {
//        return imageData;
//    }
//
//    public void setImageData(byte[] imageData) {
//        this.imageData = imageData;
//    }
}