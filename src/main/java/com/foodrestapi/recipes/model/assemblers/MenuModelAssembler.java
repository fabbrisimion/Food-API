package com.foodrestapi.recipes.model.assemblers;

import com.foodrestapi.recipes.controller.MenuController;
import com.foodrestapi.recipes.controller.RecipeController;
import com.foodrestapi.recipes.model.Menu;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MenuModelAssembler implements RepresentationModelAssembler<Menu, EntityModel<Menu>> {

    @Override
    public EntityModel<Menu> toModel(Menu menu){
        return EntityModel.of(menu,
                linkTo(methodOn(MenuController.class).getById(menu.getId())).withSelfRel(),
                linkTo(methodOn(MenuController.class).getMenu()).withRel("menu"));
    }
}