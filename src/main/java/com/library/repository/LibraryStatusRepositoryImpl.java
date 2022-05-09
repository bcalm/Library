package com.library.repository;

import com.library.domain.LibraryStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryStatusRepositoryImpl implements LibraryStatusRepository {

    private final LibraryStatus libraryStatus = LibraryStatus.builder()
        .allBooks(new ArrayList<>())
        .availableBooks(new ArrayList<>())
        .borrowedBooks(new ArrayList<>())
        .totalBooks(0)
        .availableBooksCount(0)
        .borrowedBooksCount(0)
        .build();

    public List<String> getAllBooks() {
        return libraryStatus.getAllBooks();
    }

    public List<String> addNewBook(String bookName) {
        libraryStatus.getAllBooks().add(bookName);
        Integer totalBooks = libraryStatus.getTotalBooks();
        libraryStatus.setTotalBooks(totalBooks + 1);
        addAvailableBook(bookName);
        return libraryStatus.getAllBooks();
    }

    public List<String> addAvailableBook(String bookName) {
        Integer availableBooksCount = libraryStatus.getAvailableBooksCount();
        libraryStatus.getAvailableBooks().add(bookName);
        libraryStatus.setAvailableBooksCount(availableBooksCount + 1);
        return libraryStatus.getAvailableBooks();
    }

    public List<String> addBorrowedBook(String bookName) {
        Integer borrowedBooksCount = libraryStatus.getBorrowedBooksCount();
        libraryStatus.getBorrowedBooks().add(bookName);
        libraryStatus.setBorrowedBooksCount(borrowedBooksCount + 1);
        return removeBookAvailability(bookName);
    }

    public LibraryStatus getLibraryStatus() {
        return libraryStatus;
    }

    private List<String> removeBookAvailability(String bookName) {
        Integer availableBooksCount = libraryStatus.getAvailableBooksCount();
        libraryStatus.getAvailableBooks().remove(bookName);
        libraryStatus.setAvailableBooksCount(availableBooksCount - 1);
        return libraryStatus.getBorrowedBooks();
    }
}
