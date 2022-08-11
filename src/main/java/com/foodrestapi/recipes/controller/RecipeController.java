package com.foodrestapi.recipes.controller;

import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }

    @GetMapping(value = "/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }
}
