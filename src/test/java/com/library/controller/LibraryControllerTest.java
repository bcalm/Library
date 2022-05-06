package com.library.controller;

import com.library.domain.BookModel;
import com.library.service.LibraryService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class LibraryControllerTest {

    @InjectMocks
    LibraryController libraryController;
    @Mock
    LibraryService libraryService;

    @Nested
    class BorrowBook {

        Integer bookId = 1;
        BookModel bookModel = BookModel.builder().id(bookId).build();

        @Test
        void shouldBorrowBook() {
            when(libraryService.getBook(bookId)).thenReturn(bookModel);

            ResponseEntity<BookModel> response = libraryController.getBook(bookId);

            assertThat(response.getStatusCode(), is(HttpStatus.OK));
            assertNotNull(response.getBody());
            assertThat(response.getBody().getId(), is(bookId));
        }
    }

}