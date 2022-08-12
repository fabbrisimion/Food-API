package com.foodrestapi.recipes.controller;


import com.foodrestapi.recipes.model.Food;
import com.foodrestapi.recipes.service.FoodService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    public List<Food> getFood() {
        return foodService.getFood();
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public Food getById(@PathVariable Long id){
        return foodService.getFoodById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Food createFood(@RequestBody Food newFood){
        return foodService.create(newFood);
    }

    @PutMapping(value = "/{id}")
    public Food updateFood(@PathVariable Long id, @RequestBody Food newFood){
        return foodService.update(newFood, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFood(@PathVariable Long id){
        foodService.delete(id);
    }

}
