package com.foodrestapi.recipes.controller;

import com.foodrestapi.recipes.model.Food;
import com.foodrestapi.recipes.model.assemblers.FoodModelAssembler;
import com.foodrestapi.recipes.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private FoodModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Food>> getFood() {

        List<EntityModel<Food>> food = foodService.getFood()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(food,
                linkTo(methodOn(FoodController.class).getFood()).withSelfRel());
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public EntityModel<Food> getById(@PathVariable Long id){
        Food food =  foodService.getFoodById(id);
        return assembler.toModel(food);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFood(@RequestBody Food newFood) {
        EntityModel<Food> foodEntityModel = assembler.toModel(foodService.create(newFood));
        return ResponseEntity
                .created(foodEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(foodEntityModel);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateFood(@RequestBody Food newFood, @PathVariable Long id){
        Food food =  foodService.update(newFood, id);
        EntityModel<Food> foodEntityModel = assembler.toModel(food);

        return ResponseEntity.created(foodEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(foodEntityModel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        foodService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
