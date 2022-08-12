package com.foodrestapi.recipes.controller;

import com.foodrestapi.recipes.model.Menu;
import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.model.assemblers.MenuModelAssembler;
import com.foodrestapi.recipes.model.assemblers.RecipeModelAssembler;
import com.foodrestapi.recipes.service.MenuService;
import com.foodrestapi.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Recipe>> getRecipe() {

        List<EntityModel<Recipe>> recipe = recipeService.getRecipes()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(recipe,
                linkTo(methodOn(RecipeController.class).getRecipe()).withSelfRel());
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public EntityModel<Recipe> getById(@PathVariable Long id){
        Recipe recipe = recipeService.getRecipeById(id);
        return assembler.toModel(recipe);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRecipe(@RequestBody Recipe newRecipe) {
        EntityModel<Recipe> recipeEntityModel = assembler.toModel(recipeService.create(newRecipe));
        return ResponseEntity
                .created(recipeEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(recipeEntityModel);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id){
        Recipe recipe =  recipeService.update(newRecipe, id);
        EntityModel<Recipe> recipeEntityModel = assembler.toModel(recipe);

        return ResponseEntity.created(recipeEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(recipeEntityModel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        recipeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
