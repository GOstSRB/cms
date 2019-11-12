package no.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import no.model.CartItem;
import no.model.Item;
import no.model.WorkOrder;
import no.repository.CartItemRepository;
import no.repository.ItemRepository;
import no.repository.WorkOrderRepository;
import no.service.WorkOrderService;

@Service
public class JpaWorkOrder implements WorkOrderService {

	@Autowired
	private WorkOrderRepository workOrderRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ItemRepository itemRepository;


	@Override
	public WorkOrder save(WorkOrder workorder) {
		return workOrderRepository.save(workorder);
	}

	@Override
	public WorkOrder remove(Long id) {
		WorkOrder workorder = workOrderRepository.findOne(id);
		if(workorder!=null) {
			workOrderRepository.delete(id);
		}
		return workorder;
	}

	@Override
	public WorkOrder findOne(Long id) {
		return workOrderRepository.findOne(id);
	}

	@Override
	public Page<WorkOrder> findAll(int pageNum) {
		return workOrderRepository.findAll(new PageRequest(pageNum, 20));
	}
	// workorder need to create cartitem and later cartItem insert in to self items
	@Override
	public CartItem insertItem(Long id, Long itemId, Integer quantityForOneItem) {
		
		WorkOrder w = findOne(id);
		Item i = itemRepository.findOne(itemId);
		CartItem c = null;
		
		// aviability for item check in workorder quantity for one item
		if(i.getQuantity() > 0) {
			for (int a = quantityForOneItem; a<0; a--) {
				c = new CartItem();
				c.setWorkOrder(w);
				
				cartItemRepository.save(c);
			}
			
			i.setQuantity(i.getQuantity()-quantityForOneItem);
			workOrderRepository.save(w);
		}
		
		return c;
	}

	@Override
	public CartItem insertItems(Long id, Integer quantityForOneItem) {
		// TODO Auto-generated method stub
		return null;
	}	
}