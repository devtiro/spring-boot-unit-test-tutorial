package com.devtiro.books;

import com.devtiro.books.domain.Author;
import com.devtiro.books.domain.Book;

/**
 * A utility class containing static methods to create test data.
 */
public final class TestDataUtil {

    public static Book createTestBook() {
        return Book.builder()
        .isbn("111-1-2345-6780-4")
        .title("Some Book")
        .author(Author.builder()
                .id(1L)
                .name("John Doe")
                .age(50)
                .build())
        .build();
    }

    /**
     * Private constructor as a utility class
     */
    private TestDataUtil(){
    }
}
