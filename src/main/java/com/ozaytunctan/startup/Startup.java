package com.ozaytunctan.startup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ozaytunctan.helper.enums.ConversionType;
import com.ozaytunctan.model.Ingredient;
import com.ozaytunctan.model.Recipe;
import com.ozaytunctan.model.User;
import com.ozaytunctan.repository.spec.RecipeRepository;
import com.ozaytunctan.repository.spec.UserRepository;
import com.ozaytunctan.service.spec.RecipeService;

@Component
public class Startup implements CommandLineRunner {

	@Autowired
	private RecipeService recipeService;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setUsername("ozaytunctan");

		user = this.userRepository.save(user);

		Ingredient ingredient = new Ingredient();
		ingredient.setAmount(5.0);
		ingredient.setName("Un");
		ingredient.setValue(5);
		ingredient.setConversionType(ConversionType.KG);
		ingredient.setUser(user);

		Ingredient ingredient2 = new Ingredient();
		ingredient2.setAmount(3.0);
		ingredient2.setName("Peynir");
		ingredient2.setValue(1);
		ingredient2.setConversionType(ConversionType.MG);
		ingredient2.setUser(user);

		Recipe recipes = new Recipe();
		recipes.setName("Bilice Börek");
		recipes.setDescription("Bilice börek lezzetli kahvaltı yemeğidir. Btlis yöresine ait");
		recipes.setImagePath("");
		recipes.addIngredient(ingredient);
		recipes.addIngredient(ingredient2);
		recipes.setUser(user);

		recipeRepository.saveAll(Arrays.asList(recipes));

	}

}
