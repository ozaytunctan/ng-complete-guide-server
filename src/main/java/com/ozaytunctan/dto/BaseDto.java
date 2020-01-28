package com.ozaytunctan.dto;

public class BaseDto<ID extends Number> {
	
	private ID id;
	
	public BaseDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}
	
	

}
