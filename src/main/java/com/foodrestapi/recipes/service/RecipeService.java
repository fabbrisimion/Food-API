package com.foodrestapi.recipes.service;

import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return recipeRepository.findById(id);
    }

    public void create(Recipe recipe){
        recipeRepository.saveAndFlush(recipe);
    }

    public void delete(Long id){
        recipeRepository.deleteById(id);
    }

}
