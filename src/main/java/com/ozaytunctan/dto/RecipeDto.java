package com.ozaytunctan.dto;

import java.util.List;

public class RecipeDto extends BaseDto<Integer> {

	private String name;

	private String description;

	private String imagePath;

	private List<IngredientDto> ingredients;

	public RecipeDto(Integer id) {
		super(id);
	}
	
	public RecipeDto() {
		super(0);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * @return the ingredients
	 */
	public List<IngredientDto> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<IngredientDto> ingredients) {
		this.ingredients = ingredients;
	}
	
	

	
	
}
