package com.library.service;

import com.library.domain.BookModel;
import com.library.domain.LibraryStatus;
import com.library.producer.KafkaProducer;
import com.library.repository.BookRepository;
import com.library.repository.LibraryStatusRepository;
import com.library.schema.Book;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class LibraryServiceTest {

    @InjectMocks
    LibraryService libraryService;
    @Mock
    BookRepository bookRepository;
    @Mock
    LibraryStatusRepository libraryStatusRepository;
    @Mock
    KafkaProducer producer;

    Integer bookId = 1;
    BookModel bookModel = BookModel.builder().name("demo").isBorrowed(false).id(bookId).build();
    Book book = Book.newBuilder().setId(bookModel.getId()).setIsBorrowed(true)
        .setName(bookModel.getName()).build();
    LibraryStatus libraryStatus = LibraryStatus.builder().build();

    @Nested
    class BorrowBook {
        @Test
        void shouldBorrowBook() {
            when(bookRepository.borrowBook(bookId)).thenReturn(bookModel);

            BookModel result = libraryService.getBook(bookId);

            assertThat(result.getId(), is(bookId));
            verify(producer).send(book);
        }
    }

    @Nested
    class AddBook {

        @Test
        void shouldAddTheBook() {
            libraryService.addBook(bookModel);
            book.setIsBorrowed(false);

            verify(bookRepository).addBook(bookModel);
            verify(producer).send(book);
        }

    }

    @Nested
    class ReturnBook {

        @Test
        void shouldReturnTheBook() {
            when(bookRepository.returnBook(bookId)).thenReturn(bookModel);
            book.setIsBorrowed(false);

            libraryService.returnBook(bookId);

            verify(bookRepository).returnBook(bookId);
            verify(producer).send(book);
        }

    }

    @Nested
    class GetLibraryStatus {

        @Test
        void shouldGetLibraryStatus() {
            when(libraryStatusRepository.getLibraryStatus()).thenReturn(libraryStatus);

            LibraryStatus status = libraryService.getStatus();

            assertThat(libraryStatus, is(status));
        }

    }

    @Nested
    class UpdateStatus {

        private String topic = "topic";
        private final String bookName = "testBook";
        Book book = Book.newBuilder().setId(1).setName(bookName).setIsBorrowed(false).build();
        ConsumerRecord<Integer, Book> record = new ConsumerRecord<>(topic, 1, 1, 1,  book);

        @Test
        void shouldUpdateTheStatusWhenNewBookIsAdded() {
            libraryService.updateStatus(record);

            verify(libraryStatusRepository).addNewBook(bookName);
        }

        @Test
        void shouldAddIntoTheBorrowedListIfStatusIsBorrowed() {
            when(libraryStatusRepository.getAllBooks()).thenReturn(singletonList(bookName));
            book.setIsBorrowed(true);

            libraryService.updateStatus(record);

            verify(libraryStatusRepository).addBorrowedBook(bookName);
        }

        @Test
        void shouldAddIntoTheAvailableListIfStatusIsNotBorrowed() {
            when(libraryStatusRepository.getAllBooks()).thenReturn(singletonList(bookName));

            libraryService.updateStatus(record);

            verify(libraryStatusRepository).addAvailableBook(bookName);
        }
    }
}