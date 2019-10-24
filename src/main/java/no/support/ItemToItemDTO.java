package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.Item;
import no.web.dto.ItemDTO;

@Component
public class ItemToItemDTO implements Converter<Item, ItemDTO>{

	@Override
	public ItemDTO convert(Item item) {
		ItemDTO dto = new ItemDTO();
		
		dto.setId(item.getId());
		dto.setPartName(item.getPartName());
		dto.setPartNumber(item.getPartNumber());
		dto.setPartPrice(item.getPartPrice());
		dto.setPartType(item.getPartType());
		dto.setQuantity(item.getQuantity());
		
//		dto.setWorkOrderId(item.getWorkOrder().getId());
//		dto.setWorkOrderName(item.getWorkOrder().getWorkOrderName());
		
		return dto;
	}
	
	public List<ItemDTO> convert(List<Item> items) {
		List<ItemDTO> ret = new ArrayList<>();
		
		for(Item item: items) {
			ret.add(convert(item));
		}
		return ret;
	}
	

}
