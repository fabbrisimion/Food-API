package com.foodrestapi.recipes.repository;

import com.foodrestapi.recipes.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}