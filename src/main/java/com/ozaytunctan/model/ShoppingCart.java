package com.ozaytunctan.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_SHOPPING_CART", initialValue = 1)
public class ShoppingCart extends BaseEntity<Long> {

	@Column(unique = true, length = 6)
	private String refNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart", targetEntity = ShoppingCartItem.class)
	private List<ShoppingCartItem> shoppingItem;
	
	

	public ShoppingCart(Long id) {
		super(id);
	}



	/**
	 * @return the refNumber
	 */
	public String getRefNumber() {
		return refNumber;
	}



	/**
	 * @param refNumber the refNumber to set
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}



	/**
	 * @return the shoppingItem
	 */
	public List<ShoppingCartItem> getShoppingItem() {
		return shoppingItem;
	}



	/**
	 * @param shoppingItem the shoppingItem to set
	 */
	public void setShoppingItem(List<ShoppingCartItem> shoppingItem) {
		this.shoppingItem = shoppingItem;
	}
	
	

}
