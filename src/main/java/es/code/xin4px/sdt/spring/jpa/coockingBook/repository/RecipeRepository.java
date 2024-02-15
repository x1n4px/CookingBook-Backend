package es.code.xin4px.sdt.spring.jpa.coockingBook.repository;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
     @Query("select r from Recipe r JOIN r.type t where t.name = :type")
    List<Recipe> findByType(String type);
}
