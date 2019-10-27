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
	
	private List<Item> items = new ArrayList<>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartueTime() {
		return departueTime;
	}

	public void setDepartueTime(String departueTime) {
		this.departueTime = departueTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getWorkOrderName() {
		return workOrderName;
	}

	public void setWorkOrderName(String workOrderName) {
		this.workOrderName = workOrderName;
	}

	public String getWorkOrderPhone() {
		return workOrderPhone;
	}

	public void setWorkOrderPhone(String workOrderPhone) {
		this.workOrderPhone = workOrderPhone;
	}

	public String getAdditionalComments() {
		return additionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
	





}
