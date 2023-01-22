package com.example.demo.Controller;


import com.example.demo.Service.CartService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CartController {

    private CartService cartService;

    private UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public ModelAndView showCartList(@CurrentSecurityContext(expression = "authentication?.name")
                               String email, Model model) {
        ModelAndView modelAndView = new ModelAndView("html/cart");
        modelAndView.addObject("item", cartService.findAll(userService.findUserByEmail(email).getId()));
        modelAndView.addObject("total", cartService.getTotalPrice(email, userService));
        return modelAndView;
    }
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id, @CurrentSecurityContext(expression = "authentication?.name")
                            String email){
        cartService.addCart(userService.findUserByEmail(email).getId(),id);
        return "redirect:/shop";
    }
    @PostMapping("/cart/removeItem/{index}")
    public  String cartItemRemove(@PathVariable int index,
                                  @CurrentSecurityContext(expression = "authentication?.name") String email){
        cartService.removeProductInCart(userService.findUserByEmail(email).getId(),index);
        return "redirect:/cart";
    }
}


