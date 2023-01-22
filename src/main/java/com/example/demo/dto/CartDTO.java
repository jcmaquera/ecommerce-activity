package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CartDTO {
    private int id;
    private @NotNull int userId;
    private @NotNull int productId;
    private @NotNull int quantity;




}
