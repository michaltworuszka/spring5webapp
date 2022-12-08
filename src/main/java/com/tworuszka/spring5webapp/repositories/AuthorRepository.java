package com.tworuszka.spring5webapp.repositories;

import com.tworuszka.spring5webapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Michał Tworuszka
 * @project spring5webapp
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
