package com.library.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.library.domain.BookModel;
import com.library.domain.LibraryStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LibraryRoute {

    @PostMapping(value = "/addBook")
    ResponseEntity<Object> addBook(@RequestBody Object bookModel) throws JsonProcessingException;

}
