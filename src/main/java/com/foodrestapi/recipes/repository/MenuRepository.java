package com.foodrestapi.recipes.repository;

import com.foodrestapi.recipes.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}