package com.unir.books.data.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "editorials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;
}
