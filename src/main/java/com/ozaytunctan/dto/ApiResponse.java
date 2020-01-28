package com.ozaytunctan.dto;

public class ApiResponse<D> {
	
	
	private D result;
	
	private String error;
	
	private String message;
	
	private String code;
		
	public ApiResponse() {
	}

	public ApiResponse(D result) {
		super();
		this.result = result;
	}
	
	public ApiResponse(D result,String message) {
		super();
		this.result = result;
		this.message=message;
	}

	public D getResult() {
		return result;
	}

	public void setResult(D result) {
		this.result = result;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
	
	
	

}
