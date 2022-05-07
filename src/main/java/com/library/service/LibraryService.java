package com.library.service;

import com.library.domain.BookModel;
import com.library.producer.SpringAvroProducer;
import com.library.repository.LibraryRepository;
import com.library.schema.Book;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final SpringAvroProducer producer;

    public LibraryService(LibraryRepository libraryRepository, SpringAvroProducer producer) {
        this.libraryRepository = libraryRepository;
        this.producer = producer;
    }

    public BookModel getBook(Integer bookId) {
        BookModel bookModel = libraryRepository.borrowBook(bookId);
        Book book = Book.newBuilder().setId(bookModel.getId()).setIsBorrowed(true).setName(bookModel.getName()).build();
        producer.send(book);
        return bookModel;
    }
}
