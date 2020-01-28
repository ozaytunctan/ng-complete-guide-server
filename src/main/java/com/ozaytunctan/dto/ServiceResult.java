package com.ozaytunctan.dto;

import java.util.Objects;

import com.ozaytunctan.helper.enums.ServiceResultType;

public class ServiceResult<D> {

	Exception exception;

	D data;

	ServiceResultType result;
	
	private String message;

	public ServiceResult(D data, ServiceResultType result) {
		this.result = result;
		this.data = data;
	}

	public ServiceResult(D data) {
		this.result = ServiceResultType.SUCCESS;
		this.data = data;
	}

	public ServiceResult(Exception exception) {
		this.result = ServiceResultType.ERROR;
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	public ServiceResultType getResult() {
		return result;
	}

	public void setResult(ServiceResultType result) {
		this.result = result;
	}

	public boolean isSucess() {
		return (result != null && result == ServiceResultType.SUCCESS);
	}

	public String errorMessage() {
		return Objects.nonNull(exception) ? exception.getMessage() : "";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
