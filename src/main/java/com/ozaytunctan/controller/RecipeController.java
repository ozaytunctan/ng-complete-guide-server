package com.ozaytunctan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozaytunctan.helper.ApiResponse;
import com.ozaytunctan.helper.LanguageHelper;
import com.ozaytunctan.helper.ServiceResult;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.service.spec.RecipeService;

@RestController
@RequestMapping(path = "/rest/api/v1/{lang}")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	LanguageHelper languageHelper;

	@GetMapping(path = { "/getRecipes", "/yemek-tarifi-listesi" })
	public ApiResponse<List<Recipe>> getRecipes(@PathVariable(name = "lang") String lang) {
		languageHelper.setLocale(lang);

		ServiceResult<List<Recipe>> result = this.recipeService.getRecipes();

		ApiResponse<List<Recipe>> response = new ApiResponse<>();

		if (result.isSucess()) {
			response.setResult(result.getData());
			
			response.setMessage(messageSource.getMessage("message.success", 
					            null, 
					            LocaleContextHolder.getLocale()));
			
			response.setCode(result.getResult().name());
		} else {
			response.setMessage(messageSource.getMessage("message.error",
					            null, 
					            LocaleContextHolder.getLocale()));
			response.setMessage(result.getMessage());
		}
		return response;
	}

	@PostMapping(path = "/saveRecipes")
	public ApiResponse<List<Recipe>> saveRecipe(@RequestBody List<Recipe> recipes) {

		ServiceResult<List<Recipe>> result = this.recipeService.saveRecipes(recipes);

		ApiResponse<List<Recipe>> response = new ApiResponse<>();

		if (result.isSucess()) {
			response.setResult(result.getData());
			response.setMessage("İşlem Başarılı");
			response.setCode(result.getResult().name());
		} else {
			response.setError("İşlem Başarısız");
			response.setMessage(result.getMessage());
		}

		return response;
	}

}
