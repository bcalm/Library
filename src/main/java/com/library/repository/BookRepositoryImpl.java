package com.library.repository;

import com.library.domain.BookModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BookRepositoryImpl implements BookRepository {

    HashMap<Integer, BookModel> library = new HashMap<>();

    public BookModel borrowBook(Integer bookId) {
        return library.get(bookId);
    }

    @Override
    public BookModel returnBook(Integer bookId) {
        BookModel bookModel = library.get(bookId);
        bookModel.setBorrowed(false);
        return bookModel;
    }

    public void addBook(BookModel bookModel) {
        library.put(bookModel.getId(), bookModel);
    }
}
