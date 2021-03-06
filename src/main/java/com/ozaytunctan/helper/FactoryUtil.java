package com.ozaytunctan.helper;

import java.util.Currency;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FactoryUtil {

	public Locale[] getLocales() {
		Locale[] locales = new Locale[10];
		return locales;
	}

	public Currency getAvailableCurrency() {
		Currency currency = Currency.getInstance(LocaleContextHolder.getLocale());
		return currency;
	}

}
