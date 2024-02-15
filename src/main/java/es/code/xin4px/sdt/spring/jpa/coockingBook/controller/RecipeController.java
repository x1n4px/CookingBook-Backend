package es.code.xin4px.sdt.spring.jpa.coockingBook.controller;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Converter.RecipeConverter;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Converter.RecipeIngredientConverter;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Converter.TestimonialConverter;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Recipe;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.RecipeIngredient;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Testimonials;
import es.code.xin4px.sdt.spring.jpa.coockingBook.service.RecipeIngredientService;
import es.code.xin4px.sdt.spring.jpa.coockingBook.service.RecipeService;
import es.code.xin4px.sdt.spring.jpa.coockingBook.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeIngredientService recipeIngredientService;
    @Autowired
    private TestimonialService testimonialService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAll().stream().map(RecipeConverter::toEntity).collect(Collectors.toList()));
    }

    @GetMapping("{type}")
    public ResponseEntity<List<Recipe>> getByType(@PathVariable  String type) {
        return ResponseEntity.ok(recipeService.getByType(type).stream().map(RecipeConverter::toEntity).collect(Collectors.toList()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable  Long id) {
        return ResponseEntity.ok(RecipeConverter.toEntity(recipeService.getById(id)));
    }

    @GetMapping("{id}/ingredient")
    public ResponseEntity<List<RecipeIngredient>> getIngredients(@PathVariable Long id) {
        return ResponseEntity.ok(recipeIngredientService.getIngredients(id).stream().map(RecipeIngredientConverter::toEntity).collect(Collectors.toList()));
    }

    @GetMapping("{id}/testimonials")
    public ResponseEntity<List<Testimonials>> getTestimonials(@PathVariable Long id) {
        return ResponseEntity.ok(testimonialService.getTestimonials(id).stream().map(TestimonialConverter::toEntity).collect(Collectors.toList()));
    }


}
