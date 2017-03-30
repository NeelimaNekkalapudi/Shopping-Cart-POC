package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cart.model.Order;
import com.cart.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired 
	CartService cartService;
	
	@RequestMapping(method=RequestMethod.POST,value="/")
	public void addCart(@RequestBody Order cart) {
		cartService.addCart(cart);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/")
	public void updateCart(@RequestBody Order cart) {
		cartService.updateCart(cart);
	}
	@RequestMapping("/{cartId}")
	public Order getCart(@PathVariable String cartId) {
		return cartService.getCart(cartId);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/{cartId}")
	public void deleteCart(@RequestBody Order cart,@PathVariable String cartId) {
		cartService.deleteCart(cartId,cart);
		
	}

	
}
