package es.code.xin4px.sdt.spring.jpa.coockingBook.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TYPE")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String repImage;

    @ManyToMany(mappedBy = "type")
    private Set<Recipe> recipes = new HashSet<>();
}
