package com.foodrestapi.recipes.exceptions;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException(Long id){
        super("Could not find food" + id);
    }
}
