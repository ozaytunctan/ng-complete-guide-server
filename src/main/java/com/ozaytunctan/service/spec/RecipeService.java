package com.ozaytunctan.service.spec;

import java.util.List;

import com.ozaytunctan.dto.RecipeDto;
import com.ozaytunctan.dto.RecipeSearchRequestDto;
import com.ozaytunctan.dto.ServiceResult;
import com.ozaytunctan.model.Recipe;

public interface RecipeService {

	public ServiceResult<List<Recipe>> saveRecipes(List<Recipe> recipe);

	public ServiceResult<List<Recipe>> getRecipes();

	public ServiceResult<List<RecipeDto>> searchRecipe(RecipeSearchRequestDto recipe);

}
