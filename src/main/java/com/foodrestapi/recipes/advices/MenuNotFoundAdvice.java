package com.foodrestapi.recipes.advices;

import com.foodrestapi.recipes.exceptions.MenuNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MenuNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MenuNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String menuNotFoundHandler(MenuNotFoundException mex){
        return mex.getMessage();
    }
}
