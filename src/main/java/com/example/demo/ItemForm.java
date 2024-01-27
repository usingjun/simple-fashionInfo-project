package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter @Setter
public class ItemForm {
    private Long itemId;
    private String itemName;
    private String starName;
    private Integer price;
//    private MultipartFile imageFile;
//    private List<MultipartFile> imageFiles;
}