package es.code.xin4px.sdt.spring.jpa.coockingBook.Converter;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Ingredient;

public class IngredientConverter {
    public static Ingredient toEntity(Ingredient entity) {
        if(entity == null) {
            return null;
        }

        return Ingredient.builder()
                .id(entity.getId())
                .name(entity.getName())
                .repImage(entity.getRepImage())
                .build();
    }


}
