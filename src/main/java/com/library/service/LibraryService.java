package com.library.service;

import com.library.domain.BookModel;
import com.library.domain.LibraryStatus;
import com.library.producer.KafkaProducer;
import com.library.repository.BookRepository;
import com.library.repository.LibraryStatusRepository;
import com.library.schema.Book;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
public class LibraryService {

    private final BookRepository bookRepository;
    private final KafkaProducer producer;
    private final LibraryStatusRepository libraryStatusRepository;

    public LibraryService(BookRepository bookRepository, KafkaProducer producer,
                          LibraryStatusRepository libraryStatusRepository) {
        this.bookRepository = bookRepository;
        this.producer = producer;
        this.libraryStatusRepository = libraryStatusRepository;
    }

    public BookModel getBook(Integer bookId) {
        BookModel bookModel = bookRepository.borrowBook(bookId);
        bookModel.setBorrowed(true);
        Book book = convertIntoBook(bookModel);
        producer.send(book);
        return bookModel;
    }

    public void addBook(BookModel bookModel) {
        bookRepository.addBook(bookModel);
        Book book = convertIntoBook(bookModel);
        producer.send(book);
    }

    public LibraryStatus getStatus() {
        return libraryStatusRepository.getLibraryStatus();
    }

    public void updateStatus(ConsumerRecord<Integer, Book> record) {
        List<String> allBooks = libraryStatusRepository.getAllBooks();
        Book book = record.value();
        String bookName = book.getName().toString();
        if (!allBooks.contains(bookName)) {
            libraryStatusRepository.addNewBook(bookName);
            return;
        }
        if (TRUE.equals(book.getIsBorrowed())) {
            libraryStatusRepository.addBorrowedBook(bookName);
            return;
        }
        libraryStatusRepository.addAvailableBook(bookName);
    }

    public BookModel returnBook(Integer bookId) {
        BookModel bookModel = bookRepository.returnBook(bookId);
        Book book = convertIntoBook(bookModel);
        producer.send(book);
        return bookModel;
    }

    private Book convertIntoBook(BookModel bookModel) {
        return Book.newBuilder().setId(bookModel.getId()).setIsBorrowed(bookModel.isBorrowed())
            .setName(bookModel.getName()).build();
    }
}
