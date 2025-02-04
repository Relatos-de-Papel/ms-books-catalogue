package com.unir.books.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_Id" )
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_Id")
    private Category category;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "editorial_Id")
    private Editorial editorial;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<Review> reviews;


    @Column(name ="unitPrice")
    private Long unitPrice;

    @Column(name ="ISBN")
    private String ISBN;

    @Column(name ="stock")
    private Long stock;

    @Column(name ="is_Active")
    private boolean isActive;

    @Column(name ="date_Published")
    private Date datePublished;

    @Column(name ="ranking")
    private Double ranking;

    @Column(name ="type")
    private String type;

    @Column(name ="visible")
    private boolean visible;


}
