package com.ozaytunctan.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozaytunctan.helper.ServiceResult;
import com.ozaytunctan.helper.enums.ServiceResultType;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.repository.RecipeRepository;
import com.ozaytunctan.service.spec.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	private ServiceResult<List<Recipe>> result = new ServiceResult<>(new Exception());

	@Override
	public ServiceResult<List<Recipe>> saveRecipes(List<Recipe> recipes) {

		if (Objects.nonNull(recipes) && !recipes.isEmpty()) {
			List<Recipe> addRecipeList = this.recipeRepository.saveAll(recipes);
			result = new ServiceResult<>(addRecipeList, ServiceResultType.SUCCESS);
		}
		return result;
	}

	@Override
	public ServiceResult<List<Recipe>> getRecipes() {
		List<Recipe> resipes = this.recipeRepository.findAll();
		return new ServiceResult<List<Recipe>>(resipes, ServiceResultType.SUCCESS);
	}

}
