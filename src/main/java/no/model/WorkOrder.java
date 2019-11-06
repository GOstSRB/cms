package no.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="workOrder")
public class WorkOrder {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="status")
	private String status;
	
	// Need to be date field
	@Column(name="date")
	private String date;
	
	// Need to be date-time field
	@Column(name="arrivalTime")
	private String arrivalTime;
	
	// Need to be date-time field
	@Column(name="departueTime")
	private String departueTime;
	
	//Need to be Many To One
//	@Column(name="customerName")
//	private String customerName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@Column(name="workOrderName")
	private String workOrderName;
	
	@Column(name="workOrderPhone")
	private String workOrderPhone;
	
	@Column(name="additionalComments")
	private String additionalComments;
	
	@OneToMany(mappedBy="workOrder", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Item> items = new ArrayList<>();
	
//	@ManyToMany(mappedBy="workOrder")
//	private List<Item> items = new ArrayList<>();

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(!user.getWorkOrders().contains(this)) {
			user.getWorkOrders().add(this);
		}
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

//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
//	
//	public void addItem (Item item) {
//		if(item.getWorkOrder() !=this) {
//			item.setWorkOrder(this);
//		}
//		items.add(item);
//	}


	public List<Item> getItem() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addItem (Item item) {
		if(item.getWorkOrder() !=this) {
			item.setWorkOrder(this);
		}
		items.add(item);
	}

}
