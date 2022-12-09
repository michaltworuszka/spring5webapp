package com.tworuszka.spring5webapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String addressLine1, String city, String state, String zip) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Publisher {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", addressLine1 = '" + addressLine1 + '\'' +
                ", city = '" + city + '\'' +
                ", state = '" + state + '\'' +
                ", zip = '" + zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
