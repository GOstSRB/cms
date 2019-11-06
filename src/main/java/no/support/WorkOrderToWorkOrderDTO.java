package no.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import no.model.WorkOrder;
import no.web.dto.WorkOrderDTO;

@Component
public class WorkOrderToWorkOrderDTO implements Converter<WorkOrder, WorkOrderDTO>{

	@Override
	public WorkOrderDTO convert(WorkOrder source) {
		WorkOrderDTO wodto = new WorkOrderDTO();
		
		wodto.setId(source.getId());
		wodto.setAdditionalComments(source.getAdditionalComments());
		wodto.setArrivalTime(source.getArrivalTime());
		wodto.setDate(source.getDate());
		wodto.setDepartueTime(source.getDepartueTime());
		wodto.setItems(source.getItem());
		wodto.setStatus(source.getStatus());
		wodto.setWorkOrderName(source.getWorkOrderName());
		wodto.setWorkOrderPhone(source.getWorkOrderPhone());
		
		return wodto;
	}
	
	public List<WorkOrderDTO> convert(List<WorkOrder> workorders){
		List<WorkOrderDTO> ret = new ArrayList<>();
		for(WorkOrder workOrder:workorders) {
			ret.add(convert(workOrder));
		}
		return ret;
	}
	

}
