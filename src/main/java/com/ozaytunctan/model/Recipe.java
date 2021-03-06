package com.ozaytunctan.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe extends BaseEntity<Integer> {

	private String name;

	private String description;

	private String imagePath;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "recipe", targetEntity = Ingredient.class)
	private List<Ingredient> ingredients;

	public Recipe() {
		super(0);
	}

	public Recipe(Integer id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

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
	 * @param imagePath
	 *            the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void addIngredient(Ingredient ingredient) {
		if (this.getIngredients() == null)
			this.setIngredients(new ArrayList<Ingredient>());

		ingredient.setRecipe(this);
		this.getIngredients().add(ingredient);

	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

}
