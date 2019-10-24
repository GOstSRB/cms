package no.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.model.Item;
import no.repository.ItemRepository;
import no.service.ItemService;

@Service
public class JpaItemService implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public Item remove(Long id) {
		
		Item item = itemRepository.findOne(id);
		if(item != null) {
			itemRepository.save(item);
		}
		return item;
	}

	@Override
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public List<Item> findByPartNameLike(String name) {
		return itemRepository.findByPartNameLike("%"+name+"%");
	}

	
}
