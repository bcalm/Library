package com.library.repository;

import com.library.domain.LibraryStatus;

import java.util.List;

public interface LibraryStatusRepository {

    LibraryStatus getLibraryStatus();

    List<String> getAllBooks();

    List<String> addNewBook(String bookName);

    List<String> addBorrowedBook(String bookName);

    List<String> addAvailableBook(String bookName);
}
