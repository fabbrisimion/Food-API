package com.foodrestapi.recipes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue
    @Column(name = "ingredient_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "foodpiece_id")
    private Food foodpiece;

    @ManyToOne
    @JoinColumn(name = "rec_id")
    private Recipe rec;

    @Column(name = "amount", nullable = false, length = 30)
    private String amount;
}