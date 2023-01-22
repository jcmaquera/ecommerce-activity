package com.example.demo.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", referencedColumnName = "category_id")
  private Category category;

    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;

    @Column(name = "image_name")
    private String image_name;


    @ManyToMany (cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "cart",
            joinColumns= {@JoinColumn(name = "product_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")}
    )

    private List<Cart> cart;







}
