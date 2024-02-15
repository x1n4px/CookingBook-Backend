package es.code.xin4px.sdt.spring.jpa.coockingBook.repository;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
    @Query("Select i from RecipeIngredient i where i.recipe.id = :id")
    List<RecipeIngredient> getIngredienteByRecipe(Long id);
}
