package com.devtiro.books.repositories;

import com.devtiro.books.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository for persisting books.
 *
 * <p>Extending {@link CrudRepository} gives us the following functionality: - Create a book in the
 * database - Read books from the database - Update books in the database - Delete books from the
 * database
 *
 * <p>Extending {@link PagingAndSortingRepository} gives us easy pagination and sorting! (go
 * figure).
 *
 * <p>We don't have to provide an implementation here, Spring Data JPA does it for us!
 */
public interface BookRepository
    extends CrudRepository<Book, String>, PagingAndSortingRepository<Book, String> {}
