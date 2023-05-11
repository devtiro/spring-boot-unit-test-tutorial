package com.devtiro.books.services;

import com.devtiro.books.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

  Page<Book> listBooks(Pageable pagable);

  Book getBookWithYoungestAuthor();
}
