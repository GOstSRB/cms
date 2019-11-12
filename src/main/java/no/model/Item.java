package no.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="partName")
	private String partName;
	
	// Batteries, Honeywell, Cameras, Wire
	@Column(name="partType")
	private String partType;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="partNumber")
	private String partNumber;
	
	@Column(name="partPrice")
	private Double partPrice;

	//for number of items from magacin to workorder
	@OneToMany(mappedBy="item", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<>();
	
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

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public void addCartItem(CartItem cartItem) {
		this.cartItems.add(cartItem);
		if (!this.equals(cartItem.getItem())) {
			cartItem.setItem(this);
		}
	}
}
