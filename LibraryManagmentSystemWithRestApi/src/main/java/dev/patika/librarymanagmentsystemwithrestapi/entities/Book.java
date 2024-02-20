package dev.patika.librarymanagmentsystemwithrestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name",nullable = false)
    private String name;

    @Column(name = "book_publication_year",nullable = false)
    private int publicationYear;

    @Column(name = "book_stock")
    private int stock;

    @OneToMany(mappedBy = "book")
    private List<BookBorrowing> bookBorrowingList;

    @ManyToMany()
    @JoinTable(
            name = "categories2books",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List <Category> categorylist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_author_id",referencedColumnName = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_publisher_id",referencedColumnName = "publisher_id")
    private Publisher publisher;

}
