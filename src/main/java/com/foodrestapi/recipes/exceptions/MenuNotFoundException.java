package com.foodrestapi.recipes.exceptions;

public class MenuNotFoundException extends RuntimeException{
    MenuNotFoundException(Long id){
        super("Could not find menu "+ id);
    }
}
