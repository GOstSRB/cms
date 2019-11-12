package no.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.model.CartItem;
import no.repository.CartItemRepository;
import no.service.CartItemService;

@Service
public class JpaCartItemService implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem remove(Long id) {
		CartItem cartItem = cartItemRepository.findOne(id);
		if(cartItem !=null) {
			cartItemRepository.delete(id);
		}
		return null;
	}

	@Override
	public CartItem findOne(Long id) {
			return cartItemRepository.findOne(id);
	}

	@Override
	public List<CartItem> findAll() {
		return cartItemRepository.findAll();
	}

	@Override
	public List<CartItem> findByWorkOrderId(Long id) {
		// TODO Auto-generated method stub
		return cartItemRepository.findByWorkOrderId(id);
	}

}
