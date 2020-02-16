package com.ozaytunctan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ozaytunctan.helper.enums.ConversionType;

/**
 * Yemek Malzeme
 * 
 * @author ozaytunctan
 *
 */
@Entity
@Table
@SequenceGenerator(sequenceName = "sq_ingredient",initialValue=1, name = "idGenerator")
public class Ingredient extends BaseEntity<Long> {

	private String name;

	private Double amount;

	private Integer value;

	@Enumerated(EnumType.ORDINAL)
	private ConversionType conversionType;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Recipe.class)
	@JoinColumn(columnDefinition = "recipe_id", foreignKey = @ForeignKey(name = "Ingredient_Recipe_FK"), referencedColumnName = "id")
	private Recipe recipe;

	public Ingredient() {
		super(0L);
	}

	public Ingredient(Long id) {
		super(id);
	}

	public Ingredient(Long id, String name, Double amount, Integer value, ConversionType conversionType) {
		super(id);
		this.name = name;
		this.amount = amount;
		this.value = value;
		this.conversionType = conversionType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public ConversionType getConversionType() {
		return conversionType;
	}

	public void setConversionType(ConversionType conversionType) {
		this.conversionType = conversionType;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
