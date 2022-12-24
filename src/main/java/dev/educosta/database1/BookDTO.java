package dev.educosta.database1;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "books", schema = "dbo")
@Entity(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_fk")
    private AuthorDTO author;

}
