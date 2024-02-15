package es.code.xin4px.sdt.spring.jpa.coockingBook.Converter;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.RecipeIngredient;

public class RecipeIngredientConverter {
    public static RecipeIngredient toEntity(RecipeIngredient entity) {
        if(entity == null) {
            return null;
        }

        return RecipeIngredient.builder()
                .id(entity.getId())
                 .ingredient(IngredientConverter.toEntity(entity.getIngredient()))
                .quantity(entity.getQuantity())
                .build();
    }


}
