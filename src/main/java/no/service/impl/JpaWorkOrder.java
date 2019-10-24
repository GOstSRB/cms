package no.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.model.WorkOrder;
import no.repository.WorkOrderRepository;
import no.service.WorkOrderService;

@Service
public class JpaWorkOrder implements WorkOrderService {

	@Autowired
	private WorkOrderRepository workOrderRepository;


	@Override
	public WorkOrder save(WorkOrder workorder) {
		// TODO Auto-generated method stub
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
	
	
}