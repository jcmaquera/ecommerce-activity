package com.example.demo.Repository;

import com.example.demo.dto.PriceDTO;
import com.example.demo.dto.TotalCartDTO;
import com.example.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByProductId(int product_id);

    Cart findByUserId(int user_id);

    @Query(nativeQuery = true, value = "select *" +
        " from Cart c where c.product_id=:id AND c.user_id=:user_id ")
    Cart returnResult(@Param("id") int id, @Param("user_id") int user_id);

//    @Query(nativeQuery = true,
//    value = " select c.cart_id, c.product_id as cartproduct_id, c.quantity as cartquantity, c.user_id as cartuser_id, " +
//        " p.id, p.name, p.category_id, p.description, p.quantity, " +
//        " p.price, p.image_name from Cart c " +
//        " inner join Products p on c.product_id = p.id where c.user_id=:user_id and c.quantity > 0 ")
    @Query(nativeQuery = true)
    List<TotalCartDTO[]> productsInCart(@Param("user_id")int user_id);

    @Query(nativeQuery = true)
    List<PriceDTO[]> findQuantityAndPriceUsingId(@Param("user_id")int user_id);
}
