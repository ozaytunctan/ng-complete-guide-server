package com.ozaytunctan.dto;

import com.ozaytunctan.helper.enums.ConversionType;

public class IngredientDto extends BaseDto<Long> {

	private String name;

	private Double amount;

	private Integer value;

	private ConversionType conversionType;

	private Long recipeId;

	private UserDto user;

	public IngredientDto(Long id) {
		super(id);
	}

	public IngredientDto() {
		super(0l);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the conversionType
	 */
	public ConversionType getConversionType() {
		return conversionType;
	}

	/**
	 * @param conversionType
	 *            the conversionType to set
	 */
	public void setConversionType(ConversionType conversionType) {
		this.conversionType = conversionType;
	}

	/**
	 * @return the recipeId
	 */
	public Long getRecipeId() {
		return recipeId;
	}

	/**
	 * @param recipeId
	 *            the recipeId to set
	 */
	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	/**
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}

}
