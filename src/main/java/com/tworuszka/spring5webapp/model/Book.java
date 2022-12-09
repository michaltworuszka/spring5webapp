package com.tworuszka.spring5webapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Michał Tworuszka
 * @project spring5webapp
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", isbn = '" + isbn + '\'' +
                ", authors = " + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
