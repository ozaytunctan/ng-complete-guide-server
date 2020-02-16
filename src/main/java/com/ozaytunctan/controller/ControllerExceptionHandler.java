package com.ozaytunctan.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ozaytunctan.dto.ApiResponse;
import com.ozaytunctan.exceptions.BusinessException;
import com.ozaytunctan.service.MessagesImpl;

@ControllerAdvice
public class ControllerExceptionHandler {

	@Autowired
	private MessagesImpl messages;

	@ExceptionHandler(value = { NullPointerException.class })
	public ResponseEntity<ApiResponse<String>> exceptionHandler(NullPointerException exception) {
		return null;
	}

	@ExceptionHandler(value = { BusinessException.class })
	public ResponseEntity<ApiResponse<String>> businesException(BusinessException business) {
		ApiResponse<String> response = new ApiResponse<>();
		if (Objects.nonNull(business)) {
			String messageKey = business.getMessage();
			String message = messages.get(messageKey);
			response.setCode("404");
			response.setError(message);
		}
		return ResponseEntity.ok(response);
	}

}
