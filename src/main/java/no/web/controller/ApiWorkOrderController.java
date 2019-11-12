package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.model.CartItem;
import no.model.Item;
import no.model.WorkOrder;
import no.service.CartItemService;
import no.service.ItemService;
import no.service.WorkOrderService;

import no.support.CartItemToCartItemDTO;
import no.support.WorkOrderDTOToWorkOrder;
import no.support.WorkOrderToWorkOrderDTO;
import no.web.dto.CartItemDTO;
import no.web.dto.ItemDTO;
import no.web.dto.WorkOrderDTO;

@RestController
@RequestMapping(value="/api/workorders")
public class ApiWorkOrderController {
	
	@Autowired
	private WorkOrderService workOrderService;
	@Autowired
	private WorkOrderDTOToWorkOrder toWorkOrder;
	@Autowired
	private WorkOrderToWorkOrderDTO toDTO;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CartItemToCartItemDTO toCartItemDTO;
	
	//get all
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<WorkOrderDTO>>get(@RequestParam(defaultValue="0") int pageNum){
		
		Page<WorkOrder> workorder;
		workorder = workOrderService.findAll(pageNum);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(workorder.getTotalPages()));
		
		
		return new ResponseEntity<>(toDTO.convert(workorder.getContent()), headers, HttpStatus.OK);
	}
	//get one WO
	@RequestMapping(value="/{id}", method=RequestMethod.GET) public ResponseEntity<WorkOrderDTO> getWorkOrder(@PathVariable Long id) {
		WorkOrder workOrder = workOrderService.findOne(id);
		if(workOrder == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				toDTO.convert(workOrder), HttpStatus.OK);
	}

// not good solution
@RequestMapping(method=RequestMethod.POST, value="/{id}") public ResponseEntity<CartItemDTO> insertItemInWorkOrder(
		@PathVariable Long id,
		@RequestParam (required=false) Integer quantityForOneItem,
		@RequestParam (required=false) Long itemId) {
	
	CartItem c;
	if (quantityForOneItem !=null) {
		c = workOrderService.insertItem(id, itemId, quantityForOneItem);
	} else {
		c = workOrderService.insertItems(itemId, quantityForOneItem);
	}
	
	return new ResponseEntity<>(toCartItemDTO.convert(c), HttpStatus.CREATED);
	
	}

@RequestMapping(value= "{id}/cartItems", method=RequestMethod.GET)
ResponseEntity<List<CartItemDTO>> getWorkOrdersItems(
		@PathVariable Long id, @RequestParam(defaultValue="0") int pageNum){
	
	List <CartItem> cartItemPage = cartItemService.findByWorkOrderId(id);
	
//	if(recordsPage == null || recordsPage.getContent().isEmpty()){
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	
//	HttpHeaders headers = new HttpHeaders();
//	headers.add("totalPages", Integer.toString(recordsPage.getTotalPages()) );
	
	return new ResponseEntity<>(
			toCartItemDTO.convert(cartItemPage),

			HttpStatus.OK);
}

}