package no.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.Item;
import no.service.ItemService;
import no.web.dto.ItemDTO;

@Component
public class ItemDTOToItem implements Converter<ItemDTO, Item>{
	
	@Autowired
	private ItemService itemService;
	
	@Override
	public Item convert(ItemDTO itemDTO) {
		// TODO Auto-generated method stub
		Item item = null;
		if (itemDTO.getId() != null) {
			item = itemService.findOne(itemDTO.getId());
		} else {
			item = new Item();
		}
		//When we insert new item to our store...
		item.setId(itemDTO.getId());
		item.setPartName(itemDTO.getPartName());
		item.setPartNumber(itemDTO.getPartNumber());
		item.setPartPrice(itemDTO.getPartPrice());
		item.setPartType(itemDTO.getPartType());
		item.setQuantity(itemDTO.getQuantity());
		// work order??? 
//		item.setWorkOrder(itemDTO);
		
		
		return item;
	}

}
