package com.unir.books.data.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "reviews")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_Id", insertable = false, updatable = false)
    @JsonBackReference
    private Book book;

    @Column(name ="user_Id")
    private Long userId;

    @Column(name ="review")
    private String review;

    @Column(name ="rank")
    private String rank;
}


