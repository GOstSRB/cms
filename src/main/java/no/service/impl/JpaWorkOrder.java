package no.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	
}