package com.ozaytunctan.exceptions;


@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {	
	
	public BusinessException(String messageCode) {
      super(messageCode);
	}
}
