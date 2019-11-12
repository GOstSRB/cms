package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.model.CartItem;
import no.service.CartItemService;
import no.support.CartItemToCartItemDTO;
import no.web.dto.CartItemDTO;

@RestController
@RequestMapping(value="/api/cartitems")
public class ApiCartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CartItemToCartItemDTO toDTO;
	
	@RequestMapping(method=RequestMethod.GET) 
	public ResponseEntity<List<CartItemDTO>> get(@RequestParam(defaultValue="0") int pageNum) {
		
		List<CartItem> cartItem;
		cartItem = cartItemService.findAll();
		return new ResponseEntity<> (toDTO.convert(cartItem), HttpStatus.OK);
		
	}

}
