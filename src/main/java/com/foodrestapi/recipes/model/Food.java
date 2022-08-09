package com.foodrestapi.recipes.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter @Getter @NoArgsConstructor
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @Column(name = "food_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_cat")
    //private FoodCategory foodCat;

    @Column(name = "food_name", nullable = false, length = 30)
    private String foodName;

    @Column(name = "kcal", nullable = false)
    private Integer kcal;

    @Column(name = "carbohydrates", nullable = false)
    private Integer carbohydrates;

    @Column(name = "protein", nullable = false)
    private Integer protein;

    @Column(name = "lipids", nullable = false)
    private Integer lipids;

    @ManyToMany(mappedBy = "ingredients")
    List<Recipe> recipes;
}