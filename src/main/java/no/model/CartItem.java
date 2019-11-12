package no.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//we need to include list of items with their quantity when we have more then one item on workorder list
//for workorder api
@Entity
public class CartItem {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private WorkOrder workOrder;
		
	@ManyToOne(fetch=FetchType.EAGER)
	private Item item;
	
	@Column
	private Integer quantityForOneItem;
	
	@Column
	private Double price;
	
	@Column
	private Double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
		if(workOrder != null && !workOrder.getCartItems().contains(this)) {
			workOrder.getCartItems().add(this);
		}
	}

	public Integer getQuantityForOneItem() {
		return quantityForOneItem;
	}

	public void setQuantityForOneItem(Integer quantityForOneItem) {
		this.quantityForOneItem = quantityForOneItem;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
		if(item !=null && !item.getCartItems().contains(this)) {
			item.getCartItems().add(this);
		}
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
