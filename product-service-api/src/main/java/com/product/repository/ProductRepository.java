package com.product.repository;

import com.product.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findBySkuidIgnoreCaseContaining(String keyword);

    Product findById(Long id);

    /*void delete(Product deleted);

    List<Product> findAll();

    Product findOne(Long id);

    Product save(Product saved);*/
}
