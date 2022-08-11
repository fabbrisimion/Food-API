package com.foodrestapi.recipes.controller;

import com.foodrestapi.recipes.model.Food;
import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Recipe createRecipe(@RequestBody Recipe newRecipe){
        return recipeService.create(newRecipe);
    }

    @PutMapping(value = "/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe newRecipe){
        return recipeService.update(newRecipe, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.delete(id);
    }
}
