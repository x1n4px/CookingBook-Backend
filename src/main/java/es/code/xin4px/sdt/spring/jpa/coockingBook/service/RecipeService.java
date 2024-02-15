package es.code.xin4px.sdt.spring.jpa.coockingBook.service;

import es.code.xin4px.sdt.spring.jpa.coockingBook.repository.RecipeRepository;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRespository;
    public List<Recipe> getAll() {
        return recipeRespository.findAll();
    }

    public List<Recipe> getByType(String type) {
        return recipeRespository.findByType(type);
    }

    public Recipe getById(Long id) {
        return recipeRespository.findById(id).orElse(null);
    }
}
