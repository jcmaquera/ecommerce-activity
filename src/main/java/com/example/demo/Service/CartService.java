package com.example.demo.Service;

import com.example.demo.Repository.CartRepository;
import com.example.demo.dto.PriceDTO;
import com.example.demo.dto.TotalCartDTO;
import com.example.demo.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addCart(int user_id, int product_id){
        Cart cart = cartRepository.returnResult(product_id, user_id);
        if(cart == null){
            Cart newCart = new Cart();
            newCart.setCartId(newCart.getCartId());
            newCart.setUserId(user_id);
            newCart.setProductId(product_id);
            newCart.setQuantity(1);
            cartRepository.save(newCart);
        } else if (cart != null){
            cart.setCartId(cart.getCartId());
            cart.setProductId(product_id);
            cart.setQuantity(cart.getQuantity()+1);
            cart.setUserId(user_id);
            cartRepository.save(cart);
        }
    }
    public void removeProductInCart(int user_id, int product_id) {
        Cart cart = cartRepository.returnResult(product_id, user_id);
        if (cart != null && cart.getQuantity() > 0) {
            cart.setCartId(cart.getCartId());
            cart.setProductId(product_id);
            cart.setQuantity(cart.getQuantity()-1);
            cart.setUserId(user_id);
            cartRepository.save(cart);


        }
    }
    public List<TotalCartDTO[]> findAll(int user_id){
        // ADD
        List<TotalCartDTO[]> totalCartDTOS = cartRepository.productsInCart(user_id);
        for(TotalCartDTO[] totalCartDTOS1 : totalCartDTOS) {
            double totalPricePerProduct = 0;
            for(int i = 0; i < totalCartDTOS1.length; i++) {
                totalPricePerProduct = totalCartDTOS1[i].getCartquantity() * totalCartDTOS1[i].getPrice();
                totalCartDTOS1[i].setPrice(totalPricePerProduct);
            }
        }
        return totalCartDTOS;
    }

    public List<PriceDTO[]> findQuantityAndPrice(int user_id) {
        return cartRepository.findQuantityAndPriceUsingId(user_id);
    }

    public Double getTotalPrice(String email, UserService userService) {
        double totalPrice = 0;
        List<PriceDTO[]> priceDTOS = findQuantityAndPrice(userService.findUserByEmail(email).getId());
        for(PriceDTO[] priceDTOS1 : priceDTOS) {
            for(int i = 0; i < priceDTOS1.length; i++) {
                PriceDTO priceDTO = priceDTOS1[i];
                totalPrice += (priceDTO.getCartquantity() * priceDTO.getPrice());
            }
        }
        return totalPrice;
    }

}
