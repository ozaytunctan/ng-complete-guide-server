package com.ozaytunctan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_SHOPPING_ITEM", initialValue = 1)
public class ShoppingCartItem extends BaseEntity<Long> {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Ingredient.class)
	@JoinColumn(name = "ingredient_id", nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "FK_ShoppingItem_INGREDIENT"), referencedColumnName = "id")
	private Ingredient Ingredient;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ShoppingCart.class)
	@JoinColumn(name = "shopping_id", nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "FK_ShoppingItem_SHOPPING_CART"), referencedColumnName = "id")
	private ShoppingCart shoppingCart;

	public ShoppingCartItem() {
		super(0l);
	}

	public ShoppingCartItem(Long id) {
		super(id);
	}

	/**
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return Ingredient;
	}

	/**
	 * @param ingredient
	 *            the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		Ingredient = ingredient;
	}

	/**
	 * @return the shoppingCart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * @param shoppingCart
	 *            the shoppingCart to set
	 */
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
