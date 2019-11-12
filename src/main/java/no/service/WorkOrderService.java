package no.service;

import org.springframework.data.domain.Page;

import no.model.CartItem;
import no.model.WorkOrder;

public interface WorkOrderService {
	
	WorkOrder save(WorkOrder workorder);
	WorkOrder remove(Long id);
	WorkOrder findOne(Long id);
	Page<WorkOrder>findAll(int pageNum);
	
	CartItem insertItem (Long id, Long itemId, Integer quantityForOneItem);
	CartItem insertItems (Long id, Integer quantityForOneItem);
	// Here list of all items from workorder and change their quantity
	
	

}
