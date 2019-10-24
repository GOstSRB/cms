package no.web.dto;

import javax.validation.constraints.Min;

import no.model.WorkOrder;

public class ItemDTO {
	
		private Long id;
		@Min(1)
		private Long quantity;
		private String partType;
		private String partName;
		private String partNumber;
		private Double partPrice;
//		private WorkOrder workOrder;
		private Long workOrderId;
		private String workOrderName;

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


}