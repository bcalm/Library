package com.library.repository;

import com.library.domain.BookModel;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
class BookRepositoryTest {

    @InjectMocks
    BookRepositoryImpl bookRepository;

    Integer bookId = 1;
    BookModel bookModel = BookModel.builder().id(bookId).build();

    @Nested
    class AddAndBorrowBook {

        @Test
        void shouldAddAndBorrowBook() {
            bookRepository.addBook(bookModel);
            BookModel book = bookRepository.borrowBook(bookId);

            assertThat(book.getId(), is(bookId));
        }
    }

}