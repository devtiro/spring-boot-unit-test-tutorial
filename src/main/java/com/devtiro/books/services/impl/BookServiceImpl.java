package com.devtiro.books.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devtiro.books.domain.Book;
import com.devtiro.books.repositories.BookRepository;
import com.devtiro.books.services.BookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> listBooks(final Pageable pageable) {
        log.info("Getting books...");
        return bookRepository.findAll(pageable);
    }

}
