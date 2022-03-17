package by.lamaka.springmvc.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    Genre genre;
    @Column(name = "author", nullable = false)
    @Enumerated(EnumType.STRING)
    Author author;
    @Column(name = "dateOfProduction", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    Date dateOfProduction;
}
