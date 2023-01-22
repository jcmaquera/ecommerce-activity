package com.example.demo.dto;


public class PriceDTO {
   private int cartquantity;
   private double price;

   public PriceDTO(int cartquantity, double price) {
      this.cartquantity = cartquantity;
      this.price = price;
   }

   public int getCartquantity() {
      return cartquantity;
   }

   public void setCartquantity(int cartquantity) {
      this.cartquantity = cartquantity;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
