package es.code.xin4px.sdt.spring.jpa.coockingBook.Converter;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Recipe;
import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Type;

public class RecipeConverter {

    public static Recipe toEntity(Recipe entity) {
        if(entity == null) {
            return null;
        }


        return Recipe.builder()
                .id(entity.getId())
                .name(entity.getName())
                .step(entity.getStep())
                .repImage(entity.getRepImage())
                .originalHref(entity.getOriginalHref())
                .originalTitle(entity.getOriginalTitle())

                .build();
    }

    public static Type toExternal(Type entity) {
        if(entity == null) {
            return null;
        }

        return Type.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
