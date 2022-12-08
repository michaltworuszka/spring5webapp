package com.tworuszka.spring5webapp.repositories;

import com.tworuszka.spring5webapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Michał Tworuszka
 * @project spring5webapp
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
