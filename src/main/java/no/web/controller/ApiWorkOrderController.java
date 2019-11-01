package no.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.model.WorkOrder;
import no.service.WorkOrderService;
import no.support.WorkOrderDTOToWorkOrder;
import no.support.WorkOrderToWorkOrderDTO;
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
	
	//get svee
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<WorkOrderDTO>>get(@RequestParam(defaultValue="0") int pageNum){
		
		
		
		
		Page<WorkOrder> workorder;
		workorder = workOrderService.findAll(pageNum);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(workorder.getTotalPages()));
		
		
		
		return new ResponseEntity<>(toDTO.convert(workorder.getContent()), headers, HttpStatus.OK);
	}

	
	
	
	
	
	
	
}
