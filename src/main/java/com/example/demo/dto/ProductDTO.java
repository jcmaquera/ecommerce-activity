package com.example.demo.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private int categoryId;
    private double price;
    private int quantity;
    private String description;
    private String imageName;
//    private int user_id;

}
