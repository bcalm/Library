package com.library.service;

import com.library.domain.BookModel;
import com.library.producer.SpringAvroProducer;
import com.library.repository.LibraryRepository;
import com.library.schema.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class LibraryServiceTest {

    @InjectMocks
    LibraryService libraryService;
    @Mock
    LibraryRepository libraryRepository;
    @Mock
    SpringAvroProducer producer;

    Integer bookId = 1;
    BookModel bookModel = BookModel.builder().name("demo").isBorrowed(false).id(bookId).build();
    Book book = Book.newBuilder().setId(bookModel.getId()).setIsBorrowed(bookModel.isBorrowed())
            .setName(bookModel.getName()).build();

    @Test
    void shouldBorrowBook() {
        when(libraryRepository.borrowBook(bookId)).thenReturn(bookModel);

        BookModel result = libraryService.getBook(bookId);

        assertThat(result.getId(), is(bookId));
        verify(producer).send(book);
    }

    @Test
    void shouldAddTheBook() {
        libraryService.addBook(bookModel);

        verify(libraryRepository).addBook(bookModel);
        verify(producer).send(book);
    }

}