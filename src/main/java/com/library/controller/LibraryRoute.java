package com.library.controller;

import com.library.domain.BookModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface LibraryRoute {

    @GetMapping(value = "/borrowBook/{bookId}")
    ResponseEntity<BookModel> getBook(@PathVariable("bookId") Integer bookId);
}
