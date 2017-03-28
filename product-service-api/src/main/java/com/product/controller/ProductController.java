package com.product.controller;

import com.product.service.ProductService;
import com.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        List<Product> productList = null;
        productList = productService.getAllProducts();
        return productList;
    }

    @RequestMapping(value="/details/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long id){
        Product product = null;
        product = productService.getProduct(id);
        return product;
    }

    @RequestMapping(value="/search/{keyword}",method = RequestMethod.GET)
    public List<Product> searchProducts(@PathVariable("keyword") String keyword){
        List<Product> productList = null;
        productList = productService.searchProducts(keyword);
        return productList;
    }

}
