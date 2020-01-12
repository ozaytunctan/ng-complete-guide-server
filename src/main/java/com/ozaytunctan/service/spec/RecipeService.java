package com.ozaytunctan.service.spec;

import java.util.List;

import com.ozaytunctan.helper.ServiceResult;
import com.ozaytunctan.model.Recipe;

public interface RecipeService {
	
	public ServiceResult<List<Recipe>>saveRecipes(List<Recipe> recipe);
	
	public ServiceResult<List<Recipe>>getRecipes();
	
	
}
