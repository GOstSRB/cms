package no.service;


import no.model.WorkOrder;

public interface WorkOrderService {
	
	WorkOrder save(WorkOrder workorder);
	
	WorkOrder remove(Long id);
}
