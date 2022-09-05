package com.library.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.library.domain.BookModel;
import com.library.domain.LibraryStatus;
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

    public ResponseEntity<Object> addBook(Object bookModel) throws JsonProcessingException {
        libraryService.addBook(bookModel);
        return new ResponseEntity<>(CREATED);
    }
}
