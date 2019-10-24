package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.model.Item;
import no.service.ItemService;
import no.support.ItemDTOToItem;
import no.support.ItemToItemDTO;
import no.web.dto.ItemDTO;

@RestController
@RequestMapping(value="/api/items")
public class ApiItemController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemToItemDTO toDTO;
	
	@Autowired
	private ItemDTOToItem toItem;
	
	// only for all
//	@RequestMapping(method=RequestMethod.GET) public ResponseEntity<List<ItemDTO>> getItems() {
//		return new ResponseEntity<> (toDTO.convert(itemService.findAll()), HttpStatus.OK);
//	}
	
	// find with partial name (LIKE) or all
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<ItemDTO>> getItems(
			@RequestParam(value="name", required=false) String name){
		
		List<Item> items;
		
		if(name!=null){
			items=itemService.findByPartNameLike(name);
		}else{
			items = itemService.findAll();
		}

		return new ResponseEntity<>(
				toDTO.convert(items), 
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json") public ResponseEntity<ItemDTO> add(
			@RequestBody ItemDTO newItemDTO
			){
		Item convertedItem = itemService.save(toItem.convert(newItemDTO));
			return new ResponseEntity<>(toDTO.convert(convertedItem), HttpStatus.CREATED);
	}
	
	
}
