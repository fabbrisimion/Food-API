package com.foodrestapi.recipes.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MenuRecipeId implements Serializable {

    @Column(name = "menu_id", nullable = false)
    private Integer menuId;

    @Column(name = "recipe_id", nullable = false)
    private Integer recipeId;
}