package com.cart.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cart.model.Order;
import com.cart.repository.CartRepository;

public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public void addCart(Order cart) {
		cartRepository.save(cart);
	}

	@Override
	public void updateCart(Order cart) {
		cartRepository.save(cart);
	}

	@Override
	public Order getCart(String cartId) {
		return cartRepository.findByCartid(cartId);
	}

	@Override
	public void deleteCart(String cartId, Order cart) {
		cartRepository.delete(cartId);
	}

	
}
