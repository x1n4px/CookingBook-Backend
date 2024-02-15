package es.code.xin4px.sdt.spring.jpa.coockingBook.repository;

import es.code.xin4px.sdt.spring.jpa.coockingBook.Entity.Testimonials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface TestimonialRepository extends JpaRepository<Testimonials, Long> {
    List<Testimonials> findByRecipeId(Long id);
}
