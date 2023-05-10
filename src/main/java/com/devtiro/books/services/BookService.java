package com.devtiro.books.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devtiro.books.domain.Book;

public interface BookService {

    Page<Book> listBooks(Pageable pagable);

}
