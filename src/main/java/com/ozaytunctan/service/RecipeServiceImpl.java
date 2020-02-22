package com.ozaytunctan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ozaytunctan.dto.RecipeDto;
import com.ozaytunctan.dto.RecipeSearchRequestDto;
import com.ozaytunctan.dto.ServiceResult;
import com.ozaytunctan.exceptions.BusinessException;
import com.ozaytunctan.helper.enums.ServiceResultType;
import com.ozaytunctan.model.QRecipe;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.repository.spec.RecipeRepository;
import com.ozaytunctan.service.spec.RecipeService;
import com.querydsl.core.BooleanBuilder;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	private ServiceResult<List<Recipe>> result = new ServiceResult<>(new Exception());

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ServiceResult<List<RecipeDto>> saveRecipes(List<RecipeDto> recipes) {
		ServiceResult<List<RecipeDto>> result = new ServiceResult<>(null);

		if (Objects.isNull(recipes) || recipes.isEmpty())
			throw new BusinessException("message.error");
		else {
			List<Recipe> recipeList = this.modelMapper.map(recipes, new TypeReference<List<Recipe>>() {
			}.getType());
			List<Recipe> addRecipeList = this.recipeRepository.saveAll(recipeList);
			result = new ServiceResult<>(this.modelMapper.map(addRecipeList, new TypeReference<List<RecipeDto>>() {
			}.getType()), ServiceResultType.SUCCESS);
		}
		return result;
	}

	@Override
	public ServiceResult<List<Recipe>> getRecipes() {
		List<Recipe> resipes = this.recipeRepository.findAll();
		return new ServiceResult<List<Recipe>>(resipes, ServiceResultType.SUCCESS);
	}

	@Override
	public ServiceResult<List<RecipeDto>> searchRecipe(RecipeSearchRequestDto searchRequestDto) {
		QRecipe recipe = QRecipe.recipe;
		BooleanBuilder predicate = new BooleanBuilder();
		predicate.and(recipe.name.containsIgnoreCase(searchRequestDto.getName().toLowerCase()));
		List<Recipe> recipes = this.recipeRepository.findAll(predicate);

		List<RecipeDto> responseData = new ArrayList<RecipeDto>();

		if (Objects.nonNull(recipes) && !recipes.isEmpty()) {
			responseData = modelMapper.map(recipes, new TypeReference<List<RecipeDto>>() {
			}.getType());
		}
		return new ServiceResult<List<RecipeDto>>(responseData, ServiceResultType.SUCCESS);
	}

}
