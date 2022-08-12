package com.foodrestapi.recipes.exceptions;

public class RecipeNotFoundException extends RuntimeException {

    RecipeNotFoundException(Long id){
        super("Could not find recipe" + id);
    }
}
