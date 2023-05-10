package com.devtiro.books.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devtiro.books.domain.Book;
import com.devtiro.books.repositories.BookRepository;
import com.devtiro.books.services.BookService;

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
}
