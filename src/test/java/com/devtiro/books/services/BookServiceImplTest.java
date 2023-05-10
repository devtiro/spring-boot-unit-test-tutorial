package com.devtiro.books.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.devtiro.books.TestDataUtil;
import com.devtiro.books.domain.Book;
import com.devtiro.books.repositories.BookRepository;
import com.devtiro.books.services.impl.BookServiceImpl;

/**
 * Unit tests for {@link BookServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl underTest;

    @Test
    public void testThatListBooksReturnsFromRepository() {
        final Pageable pageable = Mockito.mock(Pageable.class);
        final Page<Book> findAllResult = new PageImpl<>(
                List.of(TestDataUtil.createTestBook()),
                pageable, 1);

        when(bookRepository.findAll(eq(pageable))).thenReturn(findAllResult);
        final Page<Book> listBooksResult = underTest.listBooks(pageable);
        assertThat(listBooksResult).isEqualTo(findAllResult);
    }

}