package com.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> productList = null;

        try{
            productList = productRepository.findAll();
        }catch (Exception e){

        }
        return productList;
    }

    public Product getProduct(Long id)
    {
        Product product = null;

        try {
            product = productRepository.getOne(id);
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
