package com.example.demo.Controller;

import com.example.demo.Service.AdminService;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class AdminController {

    private CategoryService categoryService;

    private ProductService productService;

    private UserService userService;

    private AdminService adminService;

    @Autowired
    public AdminController(CategoryService categoryService, ProductService productService,
                           UserService userService, AdminService adminService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.adminService = adminService;

    }
    @GetMapping("/admin")
    public String adminHome(){
        return "/html/adminHome";
    }
    @GetMapping("/admin/categories")
    public  String getCat(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "html/categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "html/categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()){
            model.addAttribute("category", category.get());
            return "html/categoriesAdd";
        } else
            return "404";
        }

        //Product Section
    @GetMapping("/admin/products")
    public String products(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "html/products";
    }
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "html/productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName ) throws IOException{
        userService.productAddPost(productDTO, imgName, file);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String updateProductGet(@PathVariable long id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = adminService.setProductFields(product);

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);

        return "html/productsAdd";
    }
}



