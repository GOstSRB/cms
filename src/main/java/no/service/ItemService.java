package no.service;

import java.util.List;

import no.model.Item;

public interface ItemService {

	Item save(Item item);
	
	Item remove(Long id);
	
	Item findOne(Long id);
	
	List<Item> findAll();
	
	List<Item> findBypartNameLike(String name);
	
}
