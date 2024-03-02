package es.code.xin4px.sdt.spring.jpa.coockingBook.service;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Ingredient;
import es.code.xin4px.sdt.spring.jpa.coockingBook.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;


    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
