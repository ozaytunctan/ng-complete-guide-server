package com.ozaytunctan.dto;

public class UserDto extends BaseDto<Integer> {

	private String username;

	public UserDto(Integer id) {
		super(id);
	}

	public UserDto() {
		super(0);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
