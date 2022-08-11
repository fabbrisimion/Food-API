package com.foodrestapi.recipes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
@Embeddable
public class IngredientId implements Serializable {

    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "recipe_id")
    private Long recipeId;
}