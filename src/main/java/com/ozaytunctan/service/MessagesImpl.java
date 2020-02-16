package com.ozaytunctan.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.ozaytunctan.service.spec.Messages;

@Component
public class MessagesImpl implements Messages {

	@Autowired
	private MessageSource messageSource;

	public String get(String code) {
		return get(code, LocaleContextHolder.getLocale().getLanguage());
	}

	@Override
	public String get(String key, String lang) {
		return messageSource.getMessage(key, null, Locale.forLanguageTag(lang));
	}

	@Override
	public List<String> get(String... keys) {
		return Stream.of(keys).map(key -> get(key)).collect(Collectors.toList());
	}

}
