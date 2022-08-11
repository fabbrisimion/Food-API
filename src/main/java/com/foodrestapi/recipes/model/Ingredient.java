package com.foodrestapi.recipes.model;

import com.foodrestapi.recipes.model.keys.IngredientId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @EmbeddedId
    IngredientId id;

    @ManyToOne
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    private Food food_id;

    @ManyToOne
    @MapsId("recipeId")
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Column(name = "amount")
    private String amount;
}