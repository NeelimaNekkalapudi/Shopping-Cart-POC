package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public List<Product> getAllProducts(){
        List<Product> productList = null;
        productList = productService.getAllProducts();
        return productList;
    }

    @RequestMapping("/details/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        Product product = null;
        product = productService.getProduct(id);
        return product;
    }

    @RequestMapping("/search/{keyword}")
    public List<Product> searchProducts(@PathVariable("keyword") String keyword){
        List<Product> productList = null;
        productList = productService.searchProducts(keyword);
        return productList;
    }

}
