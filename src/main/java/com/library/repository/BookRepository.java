package com.library.repository;

import com.library.domain.BookModel;

public interface BookRepository {
    
    BookModel borrowBook(Integer bookId);

    void addBook(BookModel bookModel);
}
