package com.foodrestapi.recipes.model.assemblers;

import com.foodrestapi.recipes.controller.RecipeController;
import com.foodrestapi.recipes.model.Recipe;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecipeModelAssembler implements RepresentationModelAssembler<Recipe, EntityModel<Recipe>> {

    @Override
    public EntityModel<Recipe> toModel(Recipe recipe){
        return EntityModel.of(recipe,
                linkTo(methodOn(RecipeController.class).getById(recipe.getId())).withSelfRel(),
                linkTo(methodOn(RecipeController.class).getRecipe()).withRel("recipe"));
    }
}