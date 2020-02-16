package com.ozaytunctan.repository.spec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozaytunctan.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>,ExtendedQuerydslPredicateExecutor<Ingredient> {

}
