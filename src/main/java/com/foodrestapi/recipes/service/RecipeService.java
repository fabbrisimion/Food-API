package com.foodrestapi.recipes.service;

import com.foodrestapi.recipes.exceptions.RecipeNotFoundException;
import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RecipeNotFoundException(id));
    }

    public Recipe create(Recipe recipe){
        return recipeRepository.saveAndFlush(recipe);
    }

    public Recipe update(Recipe newRecipe, Long id) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setRecipe_name(newRecipe.getRecipe_name());
                    recipe.setRecipe_description(newRecipe.getRecipe_description());
                    recipe.setRecipe_time(newRecipe.getRecipe_time());
                    recipe.setDifficulty(newRecipe.getDifficulty());
                    recipe.setIngredients(newRecipe.getIngredients());
                    return recipeRepository.save(recipe);
                })
                .orElseGet(() -> {
                    newRecipe.setId(id);
                    return recipeRepository.save(newRecipe);
                });
    }

    public void delete(Long id){
        recipeRepository.deleteById(id);
    }

}
