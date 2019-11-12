package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.CartItem;
import no.web.dto.CartItemDTO;

@Component
public class CartItemToCartItemDTO implements Converter<CartItem, CartItemDTO>{

	@Override
	public CartItemDTO convert(CartItem cartItem) {
		CartItemDTO dto = new CartItemDTO();
		dto.setId(cartItem.getId());
		
		dto.setItemId(cartItem.getItem().getId());
		dto.setPartname(cartItem.getItem().getPartName());
		dto.setPrice(cartItem.getPrice());
		dto.setQuantityForOneItem(cartItem.getQuantityForOneItem());
		
		
		dto.setWorkOrderId(cartItem.getWorkOrder().getId());
		
		return dto;
	}
	
	public List<CartItemDTO> convert(List<CartItem> cartItems) {
		List<CartItemDTO> ret = new ArrayList<>();
		for (CartItem cartItem:cartItems) {
			ret.add(convert(cartItem));
		}
		return ret;		
	}

}
