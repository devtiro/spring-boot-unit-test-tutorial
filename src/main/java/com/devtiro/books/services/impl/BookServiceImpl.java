package com.devtiro.books.services.impl;

import com.devtiro.books.domain.Author;
import com.devtiro.books.domain.Book;
import com.devtiro.books.repositories.BookRepository;
import com.devtiro.books.services.BookService;
import java.util.Optional;
import java.util.stream.StreamSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Page<Book> listBooks(final Pageable pageable) {
    return bookRepository.findAll(pageable);
  }

  /**
   * This can be better achieved using a custom Query.
   *
   * <p>Instead we do some contrived logic in here to demonstrate testing just a little bit better
   * 🫡.
   */
  @Override
  public Book getBookWithYoungestAuthor() {
    return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
        .sorted(
            (thisBook, thatBook) -> {
              if (getAuthorAgeOrThrow(thisBook) == getAuthorAgeOrThrow(thatBook)) {
                return 0;
              }
              if (getAuthorAgeOrThrow(thisBook) > getAuthorAgeOrThrow(thatBook)) {
                return 1;
              } else {
                return -1;
              }
            })
        .findFirst()
        .orElse(null);
  }

  private int getAuthorAgeOrThrow(final Book book) {
    return Optional.ofNullable(book.getAuthor())
        .map(Author::getAge)
        .orElseThrow(() -> new RuntimeException("Author did not have an age"));
  }
}
