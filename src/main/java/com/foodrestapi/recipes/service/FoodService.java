package com.foodrestapi.recipes.service;

import com.foodrestapi.recipes.model.Food;
import com.foodrestapi.recipes.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getFood(){
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodById(Long id){
        return foodRepository.findById(id);
    }

    public Food create(Food food){
        return foodRepository.save(food);
    }

    public Food update(Food newFood, Long id){
        return foodRepository.findById(id)
                .map(food -> {
                    food.setFoodName(newFood.getFoodName());
                    food.setFoodCategory(newFood.getFoodCategory());
                    food.setCalories(newFood.getCalories());
                    food.setCarbohydrates(newFood.getCarbohydrates());
                    food.setProteins(newFood.getProteins());
                    food.setLipids(newFood.getLipids());
                    return foodRepository.save(food);
                })
                .orElseGet(() -> {
                    newFood.setId(id);
                    return foodRepository.save(newFood);
                });
    }

    public void delete(Long id){
        foodRepository.deleteById(id);
    }
}
