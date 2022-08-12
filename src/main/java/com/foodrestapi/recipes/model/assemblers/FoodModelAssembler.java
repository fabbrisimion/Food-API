package com.foodrestapi.recipes.model.assemblers;

import com.foodrestapi.recipes.controller.FoodController;
import com.foodrestapi.recipes.model.Food;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class FoodModelAssembler implements RepresentationModelAssembler<Food, EntityModel<Food>> {

    @Override
    public EntityModel<Food> toModel(Food food){
        return EntityModel.of(food,
                linkTo(methodOn(FoodController.class).getById(food.getId())).withSelfRel(),
                linkTo(methodOn(FoodController.class).getFood()).withRel("food"));
    }
}
