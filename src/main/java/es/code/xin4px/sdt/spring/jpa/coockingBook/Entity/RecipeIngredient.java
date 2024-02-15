package es.code.xin4px.sdt.spring.jpa.coockingBook.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "RECIPE_INGREDIENT")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quantity;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    private Ingredient ingredient;


}
