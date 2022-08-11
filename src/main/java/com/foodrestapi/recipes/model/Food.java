package com.foodrestapi.recipes.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter @Getter @NoArgsConstructor
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_cat")
    private String foodCategory;

    @Column(name = "calories", nullable = false)
    private Integer calories;

    @Column(name = "carbs", nullable = false)
    private Integer carbohydrates;

    @Column(name = "prots", nullable = false)
    private Integer proteins;

    @Column(name = "fats", nullable = false)
    private Integer lipids;
}