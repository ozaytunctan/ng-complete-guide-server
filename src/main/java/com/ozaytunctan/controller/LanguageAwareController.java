package com.ozaytunctan.controller;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozaytunctan.dto.ApiResponse;

@RestController
@RequestMapping(path = "/api/v1/language")
public class LanguageAwareController {

	@GetMapping(path = "/setLanguage/{lang}")
	public ApiResponse<Boolean> setLanguage(@PathVariable("lang") String lang) {
		LocaleContextHolder.setLocale(Locale.forLanguageTag(lang));
		return new ApiResponse<>(true);
	}

}
