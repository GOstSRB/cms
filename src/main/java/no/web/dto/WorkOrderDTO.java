package no.web.dto;

import java.util.ArrayList;
import java.util.List;

import no.model.Item;
import no.model.User;

public class WorkOrderDTO {

	
	private Long id;
		
	private String status;
	
	// Need to be date field
	private String date;
	
	// Need to be date-time field
	private String arrivalTime;
	
	// Need to be date-time field
	private String departueTime;
	
	//	private User user;
	private Long userId;
	private String userName;
		
	private String workOrderName;
		
	private String workOrderPhone;
		
	private String additionalComments;
	
//	@OneToMany(mappedBy="workOrder", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<Item> items = new ArrayList<>();
}
