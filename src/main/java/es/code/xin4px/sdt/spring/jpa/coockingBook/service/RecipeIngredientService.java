package es.code.xin4px.sdt.spring.jpa.coockingBook.service;

import es.code.xin4px.sdt.spring.jpa.coockingBook.repository.RecipeIngredientRepository;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {
    @Autowired
    private RecipeIngredientRepository recipeIngredientService;

    public List<RecipeIngredient> getIngredients(Long id) {
        return recipeIngredientService.getIngredienteByRecipe(id);
    }
}
