package com.example.demo.Service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public ProductDTO setProductFields(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(productDTO.getName());
        productDTO.setCategoryId(product.getCategory().getId()); //comment
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImage_name());

        return productDTO;
    }
}
