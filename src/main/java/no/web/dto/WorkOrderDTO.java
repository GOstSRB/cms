package no.web.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	//	private User user (customer of workorder);
	private Long userId;
	private String userName;
		
	private String workOrderName;
		
	private String workOrderPhone;
		
	private String additionalComments;

	
	private String pocName;
	private String pocPhone;
	private String pocEmail;
	private String misc1;
	private String misc2;
	private String misc3;
//	private List<Item> items = new ArrayList<>();
	private Set<Item> itemss = new HashSet<>();
	
//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}

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

	public String getPocName() {
		return pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public String getPocPhone() {
		return pocPhone;
	}

	public void setPocPhone(String pocPhone) {
		this.pocPhone = pocPhone;
	}

	public String getPocEmail() {
		return pocEmail;
	}

	public void setPocEmail(String pocEmail) {
		this.pocEmail = pocEmail;
	}

	public String getMisc1() {
		return misc1;
	}

	public void setMisc1(String misc1) {
		this.misc1 = misc1;
	}

	public String getMisc2() {
		return misc2;
	}

	public void setMisc2(String misc2) {
		this.misc2 = misc2;
	}

	public String getMisc3() {
		return misc3;
	}

	public void setMisc3(String misc3) {
		this.misc3 = misc3;
	}

	public Set<Item> getItemss() {
		return itemss;
	}

	public void setItemss(Set<Item> itemss) {
		this.itemss = itemss;
	}
	





}
