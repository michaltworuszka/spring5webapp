package com.tworuszka.spring5webapp.bootstrap;

import com.tworuszka.spring5webapp.model.Author;
import com.tworuszka.spring5webapp.model.Book;
import com.tworuszka.spring5webapp.model.Publisher;
import com.tworuszka.spring5webapp.repositories.AuthorRepository;
import com.tworuszka.spring5webapp.repositories.BookRepository;
import com.tworuszka.spring5webapp.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Michał Tworuszka
 * @project spring5webapp
 */
@Component
@RequiredArgsConstructor
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123243245436523627");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.saveAndFlush(eric);
        authorRepository.saveAndFlush(rod);
        bookRepository.save(noEJB);
        bookRepository.save(ddd);

        Publisher publisher = new Publisher("SFG Publishing",
                "1st Avenue", "Chicago",
                "Illinois", "0980790");

        publisherRepository.save(publisher);

        ddd.setPublisher(publisher);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);

        bookRepository.saveAndFlush(noEJB);
        bookRepository.saveAndFlush(ddd);
        publisherRepository.saveAndFlush(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Numbers of books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count() + " and the publishers are: ");
        System.out.println(publisherRepository.findAll());

        System.out.println("Publisher number of Books: " + publisher.getBooks().size());
        List<Book> books = bookRepository.findAll();
        books.forEach(System.out::println);
        //System.out.println(bookRepository.findAll());

        //some testing for fun
//        Publisher pub = publisherRepository.findById(1L).orElseThrow(() -> new RuntimeException(""));
//        System.out.println("for test: " + pub.getBooks().size());


    }
}
