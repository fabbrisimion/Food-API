package com.foodrestapi.recipes.controller;

import com.foodrestapi.recipes.model.Menu;
import com.foodrestapi.recipes.model.assemblers.MenuModelAssembler;
import com.foodrestapi.recipes.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Menu>> getMenu() {

        List<EntityModel<Menu>> menu = menuService.getMenu()
                .stream().map(assembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(menu,
                linkTo(methodOn(MenuController.class).getMenu()).withSelfRel());
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public EntityModel<Menu> getById(@PathVariable Long id){
        Menu menu = menuService.getMenuById(id);
        return assembler.toModel(menu);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMenu(@RequestBody Menu newMenu) {
        EntityModel<Menu> menuEntityModel = assembler.toModel(menuService.create(newMenu));
        return ResponseEntity
                .created(menuEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(menuEntityModel);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateMenu(@RequestBody Menu newMenu, @PathVariable Long id){
        Menu menu =  menuService.update(newMenu, id);
        EntityModel<Menu> menuEntityModel = assembler.toModel(menu);

        return ResponseEntity.created(menuEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(menuEntityModel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        menuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
