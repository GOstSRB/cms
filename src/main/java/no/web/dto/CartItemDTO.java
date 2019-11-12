package no.web.dto;

public class CartItemDTO {
	
	private Long id;
	
//	private WorkOrder workOrder;
	private Long workOrderId;
	private String workOrderName;
	private Integer quantityForOneItem;
	
//	private Item Item;
	private Long itemId;
	private String partname;
	private Double price;
	private Double total;
	private Double totals;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getWorkOrderId() {
		return workOrderId;
	}
	public void setWorkOrderId(Long workOrderId) {
		this.workOrderId = workOrderId;
	}
	public String getWorkOrderName() {
		return workOrderName;
	}
	public void setWorkOrderName(String workOrderName) {
		this.workOrderName = workOrderName;
	}
	public Integer getQuantityForOneItem() {
		return quantityForOneItem;
	}
	public void setQuantityForOneItem(Integer quantityForOneItem) {
		this.quantityForOneItem = quantityForOneItem;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getPartname() {
		return partname;
	}
	public void setPartname(String partname) {
		this.partname = partname;
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
	public Double getTotals() {
		return totals;
	}
	public void setTotals(Double totals) {
		this.totals = totals;
	}
	

}
