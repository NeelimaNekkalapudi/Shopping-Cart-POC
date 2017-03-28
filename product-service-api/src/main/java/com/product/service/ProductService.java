package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProduct(Long id);
    List<Product> searchProducts(String searchKeyword);
}
