package com.foodrestapi.recipes.exceptions;

public class MenuNotFoundException extends RuntimeException{
    public MenuNotFoundException(Long id){
        super("Could not find menu "+ id);
    }
}
