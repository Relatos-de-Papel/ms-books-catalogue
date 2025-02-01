package com.unir.books.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unir.books.data.utils.Consts;
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


    @ManyToOne
    @JoinColumn(name = "author_Id", insertable = false, updatable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category_Id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "editorial_Id", insertable = false, updatable = false)
    private Editorial editorial;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<Review> reviews;


    @Column(name ="unitPrice")
    private Double unitPrice;

    @Column(name ="ISBN")
    private String ISBN;

    @Column(name ="stock")
    private Integer stock;

    @Column(name ="status")
    private String status;

    @Column(name ="datePublished")
    private Date datePublished;

    @Column(name ="ranking")
    private Integer ranking;

    @Column(name ="type")
    private String type;

}
