package com.example.demo.model;


import com.example.demo.dto.PriceDTO;
import com.example.demo.dto.TotalCartDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// query to get quantity and price
@NamedNativeQuery(name = "Cart.findQuantityAndPriceUsingId",
query = " select c.quantity as cartquantity, p.price as price from Cart c inner join Products " +
        " p on c.product_id = p.id where c.user_id=:user_id and c.quantity > 0 ",
resultSetMapping = "Mapping.PriceDTO")
@SqlResultSetMapping(name = "Mapping.PriceDTO",
        classes = @ConstructorResult(targetClass = PriceDTO.class, columns =
                {@ColumnResult(name = "cartquantity"), @ColumnResult(name = "price")}))

// query to get all
@NamedNativeQuery(name = "Cart.productsInCart", query = " select c.cart_id, c.product_id as cartproduct_id, c.quantity as cartquantity, c.user_id as cartuser_id, " +
        " p.id, p.name, p.category_id, p.description, p.quantity," +
        " p.price, p.image_name from Cart c " +
        " inner join Products p on c.product_id = p.id where c.user_id=:user_id and c.quantity > 0",
resultSetMapping = "Mapping.TotalCartDTO")
@SqlResultSetMapping(name = "Mapping.TotalCartDTO",
classes = @ConstructorResult(targetClass = TotalCartDTO.class, columns =
        {@ColumnResult(name = "cart_id"), @ColumnResult(name = "cartproduct_id"), @ColumnResult(name = "cartquantity"), @ColumnResult(name = "cartuser_id"),
        @ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "category_id"), @ColumnResult(name = "description"), @ColumnResult(name = "quantity"),
        @ColumnResult(name = "price"), @ColumnResult(name = "image_name")}))

@Entity
@Data
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "user_id")
    private int userId;
    @Column(name ="quantity")
    private int quantity;


}
