package com.library.controller;

import com.library.domain.BookModel;
import com.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class LibraryController implements LibraryRoute {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public ResponseEntity<BookModel> getBook(Integer bookId) {
        BookModel bookModel = libraryService.getBook(bookId);
        return new ResponseEntity<>(bookModel, OK);
    }
}
