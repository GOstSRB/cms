package no.service;


import org.springframework.data.domain.Page;

import no.model.WorkOrder;

public interface WorkOrderService {
	
	WorkOrder save(WorkOrder workorder);
	
	WorkOrder remove(Long id);

	WorkOrder findOne(Long id);
	
	Page<WorkOrder>findAll(int pageNum);
}
