package com.devtiro.books.controllers;

import com.devtiro.books.domain.Book;
import com.devtiro.books.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  private final BookService bookService;

  public BookController(final BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping(path = "/books")
  public ResponseEntity<Page<Book>> listBooks(final Pageable pageable) {
    return new ResponseEntity<Page<Book>>(bookService.listBooks(pageable), HttpStatus.OK);
  }
}
