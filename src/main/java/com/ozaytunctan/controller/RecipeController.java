package com.ozaytunctan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozaytunctan.helper.ApiResponse;
import com.ozaytunctan.helper.ServiceResult;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.service.spec.RecipeService;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@GetMapping(path = { "/getRecipes" })
	public ApiResponse<List<Recipe>> getRecipes() {
		
		ServiceResult<List<Recipe>> result = this.recipeService.getRecipes();
		
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
