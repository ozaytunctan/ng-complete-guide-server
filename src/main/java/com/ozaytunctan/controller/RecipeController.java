package com.ozaytunctan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozaytunctan.dto.ApiResponse;
import com.ozaytunctan.dto.ServiceResult;
import com.ozaytunctan.helper.FactoryUtil;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.service.Messages;
import com.ozaytunctan.service.spec.RecipeService;

@RestController
@RequestMapping(path = "/rest/api/v1/{lang}")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private Messages messages;

	@Autowired
	FactoryUtil languageHelper;

	@GetMapping(path = { "/getRecipes", "/yemek-tarifi-listesi" })
	public ApiResponse<List<Recipe>> getRecipes(@PathVariable(name = "lang") String lang) {
		languageHelper.setLocale(lang);

		ServiceResult<List<Recipe>> result = this.recipeService.getRecipes();

		ApiResponse<List<Recipe>> response = new ApiResponse<>();

		if (result.isSucess()) {
			response.setResult(result.getData());
			response.setMessage(messages.get("message.success"));
			response.setCode(result.getResult().name());
		} else {
			response.setMessage(messages.get("message.error"));
			response.setMessage(result.getMessage());
		}
		return response;
	}

	@PostMapping(path = "/saveRecipes")
	public ApiResponse<List<Recipe>> saveRecipe(
			@PathVariable(name = "lang") String lang,
			@RequestBody List<Recipe> recipes) {
		
		languageHelper.setLocale(lang);
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
