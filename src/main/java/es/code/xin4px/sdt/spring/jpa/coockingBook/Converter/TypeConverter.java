package es.code.xin4px.sdt.spring.jpa.coockingBook.Converter;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Type;

public class TypeConverter {
    public static Type toExternal (Type entity) {
        if(entity == null) {
            return null;
        }

        return Type.builder()
                .id(entity.getId())
                .name(entity.getName())
                .repImage(entity.getRepImage())
                .build();
    }
}
