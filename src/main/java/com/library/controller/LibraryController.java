package com.library.controller;

import com.library.domain.BookModel;
import com.library.domain.LibraryStatus;
import com.library.schema.Book;
import com.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class LibraryController implements LibraryRoute {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public ResponseEntity<BookModel> getBook(Integer bookId) {
        BookModel bookModel = libraryService.getBook(bookId);
        bookModel.setBorrowed(true);
        return new ResponseEntity<>(bookModel, OK);
    }

    public ResponseEntity<Book> addBook(BookModel bookModel) {
        libraryService.addBook(bookModel);
        return new ResponseEntity<>(CREATED);
    }

    public ResponseEntity<LibraryStatus> getLibraryStatus() {
        LibraryStatus status = libraryService.getStatus();
        return new ResponseEntity<>(status, OK);
    }
}
