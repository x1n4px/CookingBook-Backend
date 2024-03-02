package es.code.xin4px.sdt.spring.jpa.coockingBook.controller;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Converter.IngredientConverter;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Ingredient;
import es.code.xin4px.sdt.spring.jpa.coockingBook.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAll() {
        return ResponseEntity.ok(ingredientService.getAllIngredients().stream().map(IngredientConverter::toEntity).collect(Collectors.toList()));
    }
}
