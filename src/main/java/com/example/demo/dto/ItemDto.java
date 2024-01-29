package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDto {
    private Long itemId;
    private String itemName;
    private String starName;
    private Integer price;
//    private MultipartFile imageFile;
//    private List<MultipartFile> imageFiles;
}