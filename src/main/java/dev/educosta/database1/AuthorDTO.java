package dev.educosta.database1;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "authors", schema = "dbo")
@Entity(name = "authors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
