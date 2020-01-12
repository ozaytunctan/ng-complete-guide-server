package com.ozaytunctan.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class Recipe extends BaseEntity<Integer> {

	private String name;

	private String description;
	
	private String imagePath;

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
	 * @param imagePath the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	

}
