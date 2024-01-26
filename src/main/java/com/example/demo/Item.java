package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class Item {

        private Long itemId;
        private String itemName;
        private String starName;
        private Integer price;
        private UploadFile imageFile;
        private List<UploadFile> imageFiles;
        //카테고리 등 추가

        public Item() {
        }

    }

