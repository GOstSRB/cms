package no.service;

import java.util.List;

import no.model.CartItem;

public interface CartItemService {
	
	CartItem save(CartItem cartItem);
	
	CartItem remove(Long id);
	
	CartItem findOne(Long id);
	
	List<CartItem> findAll();

	List<CartItem> findByWorkOrderId(Long id);

}
