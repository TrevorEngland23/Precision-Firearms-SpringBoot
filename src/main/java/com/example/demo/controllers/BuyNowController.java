package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyNowController {
    @Autowired
    private final ProductService productService;

    public BuyNowController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/buyNow")
    public String buyNow(@RequestParam("productID") int productID) {
       Product product = productService.findById(productID);

       if (product != null && product.getInv() > 0) {
           product.setInv(product.getInv() - 1);
           productService.save(product);
           return "successfulpurchase";
       } else {
           return "unsuccessfulpurchase";
       }
    }
}
