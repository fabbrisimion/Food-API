package com.foodrestapi.recipes.advices;

import com.foodrestapi.recipes.exceptions.FoodNotFoundException;
import com.foodrestapi.recipes.exceptions.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FoodNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FoodNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String foodNotFoundHandler(FoodNotFoundException fex) {
        return fex.getMessage();
    }
}
