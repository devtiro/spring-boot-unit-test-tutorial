package com.devtiro.books.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.devtiro.books.TestDataUtil;
import com.devtiro.books.domain.Book;
import com.devtiro.books.services.BookService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/** Unit tests for {@link BookController}. */
@ExtendWith(MockitoExtension.class)
public class BookControllerTests {

  @Mock private BookService bookService;

  @InjectMocks public BookController underTest;

  @Test
  public void testThatListBooksReturnsHttp200() {
    final Pageable pageable = Mockito.mock(Pageable.class);
    final Page<Book> listBooksResult =
        new PageImpl<>(List.of(TestDataUtil.createTestBookA()), pageable, 1);

    when(bookService.listBooks(eq(pageable))).thenReturn(listBooksResult);

    final ResponseEntity<Page<Book>> result = underTest.listBooks(pageable);
    assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(result.getBody()).isEqualTo(listBooksResult);
  }

  @Test
  public void testThatListBooksReturnsBooks() {
    final Pageable pageable = Mockito.mock(Pageable.class);
    final Page<Book> listBooksResult =
        new PageImpl<>(List.of(TestDataUtil.createTestBookA()), pageable, 1);

    when(bookService.listBooks(eq(pageable))).thenReturn(listBooksResult);

    final ResponseEntity<Page<Book>> result = underTest.listBooks(pageable);
    assertThat(result.getBody()).isEqualTo(listBooksResult);
  }
}
