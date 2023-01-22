package com.example.demo.dto;


import java.math.BigInteger;

public class TotalCartDTO {
    private int cart_id;
    private int cartproduct_id;
    private int cartquantity;
    private int cartuser_id;
    private BigInteger id;
    private String name;
    private int category_id;
    private String description;
    private int quantity;
    private double price;
    private String image_name;

    public TotalCartDTO(int cart_id, int cartproduct_id, int cartquantity, int cartuser_id, BigInteger id,
                        String name, int category_id, String description, int quantity,
                        double price, String image_name) {
        this.cart_id = cart_id;
        this.cartproduct_id = cartproduct_id;
        this.cartquantity = cartquantity;
        this.cartuser_id = cartuser_id;
        this.id = id;
        this.name = name;
        this.category_id = category_id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image_name = image_name;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getCartproduct_id() {
        return cartproduct_id;
    }

    public void setCartproduct_id(int cartproduct_id) {
        this.cartproduct_id = cartproduct_id;
    }

    public int getCartquantity() {
        return cartquantity;
    }

    public void setCartquantity(int cartquantity) {
        this.cartquantity = cartquantity;
    }

    public int getCartuser_id() {
        return cartuser_id;
    }

    public void setCartuser_id(int cartuser_id) {
        this.cartuser_id = cartuser_id;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
