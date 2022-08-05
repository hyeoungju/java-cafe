package com.varxyz.javacafe.service;

import java.util.List;

import com.varxyz.javacafe.domain.Cart;

public interface CartService {
	int addCart(Cart cart);
	Cart checkCart(Cart cart);
	int updateCart(Cart cart);
	List<Cart> getCart();
}
