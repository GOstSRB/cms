package no.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="quantity")
	private Long quantity;
	
	// Batteries, Honeywell, Cameras, Wire
	@Column(name="partType")
	private String partType;
	
	@Column(name="partName")
	private String partName;
	
	@Column(name="partNumber")
	private String partNumber;
	
	@Column(name="partPrice")
	private Double partPrice;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private WorkOrder workOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public Double getPartPrice() {
		return partPrice;
	}

	public void setPartPrice(Double partPrice) {
		this.partPrice = partPrice;
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
		if(!workOrder.getItem().contains(this)) {
			workOrder.getItem().add(this);
		}
	}


}
