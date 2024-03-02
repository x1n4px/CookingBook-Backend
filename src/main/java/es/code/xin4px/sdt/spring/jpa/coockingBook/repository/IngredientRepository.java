package es.code.xin4px.sdt.spring.jpa.coockingBook.repository;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
