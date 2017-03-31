package com.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.product.service.ProductService;
import com.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    @Autowired
    private ProductService productService;

    private List<Product> getAllProductsFallback(){
        System.out.println("getAllProductsFallback");
       return Arrays.asList();
    }

    @HystrixCommand(fallbackMethod = "getAllProductsFallback")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        List<Product> productList = null;
        productList = productService.getAllProducts();
        return productList;
    }

    public Product getProductFallback(Long id){
        System.out.println("getProductFallback");
        return new Product();
    }

    @HystrixCommand(fallbackMethod = "getProductFallback")
    @RequestMapping(value="/details/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long id){
        Product product = null;
        product = productService.getProduct(id);
        return product;
    }

    private List<Product> searchProductsFallback(String keyword){
        System.out.println("searchProductsFallback");
        return Arrays.asList();
    }

    @HystrixCommand(fallbackMethod = "searchProductsFallback")
    @RequestMapping(value="/search/{keyword}",method = RequestMethod.GET)
    public List<Product> searchProducts(@PathVariable("keyword") String keyword){
        List<Product> productList = null;
        productList = productService.searchProducts(keyword);
        return productList;
    }

}
