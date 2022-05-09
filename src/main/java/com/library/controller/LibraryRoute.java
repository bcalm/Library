package com.library.controller;

import com.library.domain.BookModel;
import com.library.domain.LibraryStatus;
import com.library.schema.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LibraryRoute {

    @GetMapping(value = "/borrowBook/{bookId}")
    ResponseEntity<BookModel> getBook(@PathVariable("bookId") Integer bookId);

    @PostMapping(value = "/addBook")
    ResponseEntity<Book> addBook(@RequestBody BookModel bookModel);

    @GetMapping(value = "/library/status")
    ResponseEntity<LibraryStatus> getLibraryStatus();

    @GetMapping(value = "/returnBook/{bookId}")
    ResponseEntity<BookModel> returnBook(@PathVariable("bookId") Integer bookId);
}
