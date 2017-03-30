package com.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.model.Order;

public interface CartRepository extends JpaRepository<Order, String>{
	
	Order findByCartid(String id);
}