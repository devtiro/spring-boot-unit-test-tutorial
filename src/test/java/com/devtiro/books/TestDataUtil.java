package com.devtiro.books;

import com.devtiro.books.domain.Author;
import com.devtiro.books.domain.Book;

/** A utility class containing static methods to create test data. */
public final class TestDataUtil {

  public static Book createTestBookA() {
    return Book.builder()
        .isbn("111-1-2345-6780-4")
        .title("Some Book")
        .author(Author.builder().id(1L).name("John Doe").age(50).build())
        .build();
  }

  public static Book createTestBookB() {
    return Book.builder()
        .isbn("222-2-3456-6780-4")
        .title("Some Other Book")
        .author(Author.builder().id(1L).name("Jane Doe").age(35).build())
        .build();
  }

  public static Book createTestBookC() {
    return Book.builder()
        .isbn("333-3-45678-6780-4")
        .title("Some Other Other Book")
        .author(Author.builder().id(1L).name("Jerimiah Doe").age(60).build())
        .build();
  }

  /** Private constructor as a utility class */
  private TestDataUtil() {}
}
