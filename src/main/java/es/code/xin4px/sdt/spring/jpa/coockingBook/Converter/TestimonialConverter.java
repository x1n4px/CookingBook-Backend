package es.code.xin4px.sdt.spring.jpa.coockingBook.Converter;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Testimonials;

public class TestimonialConverter {

    public static Testimonials toEntity(Testimonials entity) {
        if(entity == null) {
            return null;
        }

        return Testimonials.builder()
                .id(entity.getId())
                .name(entity.getName())
                .testimonial(entity.getTestimonial())
                .flavor(entity.getFlavor())
                .texture(entity.getTexture())
                .presentation(entity.getPresentation())
                .build();
    }
}
