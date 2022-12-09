package com.tworuszka.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author {" +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
