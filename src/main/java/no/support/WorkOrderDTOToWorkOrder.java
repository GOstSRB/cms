package no.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.WorkOrder;
import no.service.WorkOrderService;
import no.web.dto.WorkOrderDTO;

@Component
public class WorkOrderDTOToWorkOrder implements Converter<WorkOrderDTO, WorkOrder> {
	
	@Autowired
	private WorkOrderService workOrderService;

	@Override
	public WorkOrder convert(WorkOrderDTO source) {
		WorkOrder workOrder = null;
		if(source.getId() != null) {
			workOrder = workOrderService.findOne(source.getId());
		}else {
			workOrder = new WorkOrder();
		}
		workOrder.setId(source.getId());
		workOrder.setAdditionalComments(source.getAdditionalComments());
		workOrder.setArrivalTime(source.getArrivalTime());
		workOrder.setDate(source.getDate());
		workOrder.setDepartueTime(source.getDepartueTime());
//		workOrder.setItems(source.getItems());
		workOrder.setStatus(source.getStatus());
		workOrder.setWorkOrderName(source.getWorkOrderName());
		workOrder.setWorkOrderPhone(source.getWorkOrderPhone());
		workOrder.setItemss(source.getItemss());
		return workOrder;
	}

}
