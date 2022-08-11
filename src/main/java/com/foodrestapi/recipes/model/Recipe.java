package com.foodrestapi.recipes.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name")
    private String recipe_name;

    @Column(name = "recipe_description")
    private String recipe_description;

    @Column(name = "recipe_time")
    private String recipe_time;

    @Column(name = "difficulty")
    private Integer difficulty;

    @ManyToMany
    @JoinTable(
            name = "ingredients",
            joinColumns = @JoinColumn(
                    name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List<Food> ingredients;
}