package com.foodrestapi.recipes.service;

import com.foodrestapi.recipes.model.Menu;
import com.foodrestapi.recipes.model.Recipe;
import com.foodrestapi.recipes.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenu(){
        return menuRepository.findAll();
    }

    public Optional<Menu> getMenuById(Long id) {
        return menuRepository.findById(id);
    }

    public Menu create(Menu menu){
        return menuRepository.saveAndFlush(menu);
    }

    public Menu update(Menu newMenu, Long id) {
        return menuRepository.findById(id)
                .map(menu -> {
                    menu.setName(newMenu.getName());
                    menu.setRecipes(newMenu.getRecipes());
                    return menuRepository.save(menu);
                })
                .orElseGet(() -> {
                    newMenu.setId(id);
                    return menuRepository.save(newMenu);
                });
    }

    public void delete(Long id){
        menuRepository.deleteById(id);
    }
}
