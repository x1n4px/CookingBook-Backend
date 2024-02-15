package es.code.xin4px.sdt.spring.jpa.coockingBook.service;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Testimonials;
import es.code.xin4px.sdt.spring.jpa.coockingBook.repository.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialService {
    @Autowired
    private TestimonialRepository testimonialRepository;

    public List<Testimonials> getTestimonials(Long id) {
        return testimonialRepository.findByRecipeId(id);
    }
}
