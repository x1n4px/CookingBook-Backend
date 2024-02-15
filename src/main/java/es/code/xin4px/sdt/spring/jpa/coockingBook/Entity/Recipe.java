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
@Table(name = "RECIPE")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String repImage;
    @Column(columnDefinition="varchar(2000)")
    private String step;

    private String originalHref;
    private String originalTitle;




    @ManyToMany
    @JoinTable(
            name = "TYPE_RECIPE",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private Set<Type> type = new HashSet<>();
}
