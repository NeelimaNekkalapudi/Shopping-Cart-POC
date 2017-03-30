package com.cart.service;

import com.cart.model.Order;

public interface CartService {

	public void addCart(Order cart);

	public void updateCart(Order cart);

	public Order getCart(String cartId);

	public void deleteCart(String cartId, Order cart);

}
