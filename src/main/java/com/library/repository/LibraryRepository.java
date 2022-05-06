package com.library.repository;

import com.library.domain.BookModel;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class LibraryRepository {

    HashMap<Integer, BookModel> library = new HashMap<>();

    @PostConstruct
    public void init() {
        getBooks().forEach(book -> library.put(book.getId(), book));
    }

    public BookModel borrowBook(Integer bookId) {
        return library.get(bookId);
    }

    private List<BookModel> getBooks() {
        BookModel bookModel1 = BookModel.builder().id(1).name("Head first java").build();
        BookModel bookModel2 = BookModel.builder().id(2).name("Java for dummies").build();
        return asList(bookModel1, bookModel2);

    }
}
