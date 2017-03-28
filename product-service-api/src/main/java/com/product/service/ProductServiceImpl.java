package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> productList = null;

        try{
            productList = (List<Product>) productRepository.findAll();
        }catch (Exception e){

        }
        return productList;
    }

    public Product getProduct(Long id)
    {
        Product product = null;

        try {
            product = productRepository.findOne(id);
        }catch (Exception e){

        }

        return product;
    }

    public List<Product> searchProducts(String searchKeyword)
    {
        List<Product> productList = null;

        try{
            productList = productRepository.findBySkuidIgnoreCaseContaining(searchKeyword);
        }catch (Exception e){

        }
        return productList;
    }

}
