package com.ozaytunctan.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Messages {

	@Autowired
	private MessageSource messageSource;

	public String get(String code) {
		return get(code, LocaleContextHolder.getLocale());
	}

	public String get(String code, Locale locale) {
		return messageSource.getMessage(code, null, locale);
	}
	
	
}
