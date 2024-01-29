package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Item {

        private Long itemId;
        private String itemName;
        private String starName;
        private Integer price;
        private String itemDetail;
//        private UploadFile imageFile;
//        private List<UploadFile> imageFiles;
        //카테고리 등 추가

        public Item() {
        }

        public Item(String itemName, String starName, Integer price, String itemDetail) {
                this.itemName = itemName;
                this.starName = starName;
                this.price = price;
                this.itemDetail = itemDetail;
        }
}

