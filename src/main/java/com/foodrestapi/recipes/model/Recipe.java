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
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue
    @Column(name = "recipe_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Column(name = "prep_time")
    private String prepTime;

    @Column(name = "difficulty", nullable = false)
    private Integer difficulty;

    @ManyToMany
    @JoinTable(
            name = "ingredients",
            joinColumns = @JoinColumn(name = "rec_id"),
            inverseJoinColumns = @JoinColumn(name = "foodpiece_id"))
    private List<Food> ingredients;
}