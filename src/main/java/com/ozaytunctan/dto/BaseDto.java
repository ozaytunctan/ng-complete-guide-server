package com.ozaytunctan.dto;

public class BaseDto<ID extends Number> {

	private ID id;

	public BaseDto(ID id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}

}
