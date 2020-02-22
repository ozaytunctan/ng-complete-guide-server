
package com.ozaytunctan.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ozaytunctan.dto.ApiResponse;
import com.ozaytunctan.dto.RecipeDto;
import com.ozaytunctan.dto.RecipeSearchRequestDto;
import com.ozaytunctan.dto.ServiceResult;
import com.ozaytunctan.helper.FactoryUtil;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.service.MessagesImpl;
import com.ozaytunctan.service.spec.RecipeService;

@RestController
@RequestMapping(path = "/api/v1/recipe")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private MessagesImpl messages;

	@Autowired
	FactoryUtil languageHelper;
	

	@GetMapping(path = { "/getRecipes", "/yemek-tarifi-listesi" })
	public ApiResponse<List<Recipe>> getRecipes() {
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
	public ApiResponse<List<RecipeDto>> saveRecipe(@RequestBody List<RecipeDto> recipes) {
		ServiceResult<List<RecipeDto>> result = this.recipeService.saveRecipes(recipes);

		ApiResponse<List<RecipeDto>> response = new ApiResponse<>();

		if (result.isSucess()) {
			response.setResult(result.getData());
			response.setMessage(messages.get("message.success"));
			response.setCode(result.getResult().name());
		} else {
			response.setMessage(messages.get("message.error"));
		}
		return response;
	}

	@PostMapping(path = "/searchRecipe")
	public ApiResponse<List<RecipeDto>> saveRecipe(@Valid @RequestBody RecipeSearchRequestDto searhRecipe) {
		ServiceResult<List<RecipeDto>> recipeDtos = this.recipeService.searchRecipe(searhRecipe);
		return new ApiResponse<List<RecipeDto>>(recipeDtos.getData());
	}

}
