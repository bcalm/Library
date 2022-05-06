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
class LibraryRepositoryTest {

    @InjectMocks
    LibraryRepository libraryRepository;

    @Nested
    class BorrowBook {
        Integer bookId1 = 1;
        Integer bookId2 = 2;

        @Test
        void shouldGiveTheBook() {
            libraryRepository.init();
            BookModel book1 = libraryRepository.borrowBook(bookId1);
            BookModel book2 = libraryRepository.borrowBook(bookId2);

            assertThat(book1.getId(), is(bookId1));
            assertThat(book2.getId(), is(bookId2));
        }
    }

}