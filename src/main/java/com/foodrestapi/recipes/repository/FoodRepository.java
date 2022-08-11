package com.foodrestapi.recipes.repository;

import com.foodrestapi.recipes.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}