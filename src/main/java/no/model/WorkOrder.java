package no.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	// this generate table workorder_item with id`s but I don`t know how to use...
	@ManyToMany(targetEntity = Item.class, cascade = {CascadeType.ALL})
	@JoinTable(name="workorder_item",
			joinColumns = {@JoinColumn(name="workOrder_id")},
 		    inverseJoinColumns = {@JoinColumn(name="item_id")}
	)
	private Set<Item> itemss;
	
	//for number of items from magacin to workorder
	@OneToMany(mappedBy="workOrder", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<>();
	
	@Column(name="reasonForService")
	private String reasonForService;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="customerAddress")
	private String customerAddress;
	
	@Column(name="pocName")
	private String pocName;
	
	@Column(name="pocPhone")
	private String pocPhone;
	
	@Column(name="pocEmail")
	private String pocEmail;
	
	@Column(name="misc1")
	private String misc1;
	
	@Column(name="misc2")
	private String misc2;
	
	@Column(name="misc3")
	private String misc3;
	
	@Column(name="description")
	private String description;
	
	@Column(name="quantity")
	private Integer quantity;
		
	@Column(name="unitPrice")
	private Double unitPrice;
	
	@Column(name="total")
	private Double total;
	
	@Column(name="totals")
	private Double totals;
	
	@Column(name="descriptionOfWork")
	private String descriptionOfWork;

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

	public Set<Item> getItemss() {
		return itemss;
	}

	public void setItemss(Set<Item> itemss) {
		this.itemss = itemss;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addCartItem(CartItem cartItem) {
		this.cartItems.add(cartItem);
		if (!this.equals(cartItem.getWorkOrder())) {
			cartItem.setWorkOrder(this);
		}
	}

}
