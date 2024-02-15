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
@Table(name = "TESTIMONIALS")
public class Testimonials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition="varchar(2000)")
    private String testimonial;

    private double flavor;
    private double texture;
    private double presentation;

    @ManyToOne
    private Recipe recipe;
}
