package com.ozaytunctan.helper;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LanguageHelper {

	public void setLocale(String lang) {
		LocaleContextHolder
		.setLocale(Locale
				.forLanguageTag(lang.concat("-").concat(lang.toUpperCase())));
	}

}
