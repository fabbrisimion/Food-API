package com.foodrestapi.recipes.controller;

import com.foodrestapi.recipes.model.Menu;
import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getMenu(){
        return menuService.getMenu();
    }

    @GetMapping(value = "/{id}")
    public Optional<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu createMenu(@RequestBody Menu newMenu){
        return menuService.create(newMenu);
    }

    @PutMapping(value = "/{id}")
    public Menu updateMenu(@PathVariable Long id, @RequestBody Menu newMenu){
        return menuService.update(newMenu, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
    }
}
