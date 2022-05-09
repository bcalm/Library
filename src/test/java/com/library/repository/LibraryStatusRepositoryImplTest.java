package com.library.repository;

import com.library.domain.LibraryStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class LibraryStatusRepositoryImplTest {

    LibraryStatusRepositoryImpl libraryStatusRepository = new LibraryStatusRepositoryImpl();

    String bookName = "testBook";
    String bookName2 = "testBook2";

    @Test
    void shouldAddNewBookAndGetAllBooks() {
        List<String> allBooks = libraryStatusRepository.addNewBook(bookName);

        assertThat(allBooks.size(), is(1));
        assertThat(allBooks.get(0), is(bookName));
    }

    @Test
    void shouldAddAvailableBook() {
        libraryStatusRepository.addAvailableBook(bookName2);
        List<String> availableBooks = libraryStatusRepository.addAvailableBook(bookName);

        assertThat(availableBooks.size(), is(2));
        assertThat(availableBooks.get(0), is(bookName2));

    }

    @Test
    void shouldAddAvailableBookAndRemoveFromBorrowList() {
        libraryStatusRepository.addBorrowedBook(bookName2);
        libraryStatusRepository.addAvailableBook(bookName2);
        List<String> availableBooks = libraryStatusRepository.addAvailableBook(bookName);

        assertThat(availableBooks.size(), is(2));
        assertThat(availableBooks.get(0), is(bookName2));
        assertThat(libraryStatusRepository.getLibraryStatus().getBorrowedBooksCount(), is(0));

    }

    @Test
    void addBorrowedBook() {
        libraryStatusRepository.addBorrowedBook(bookName2);
        List<String> borrowedBook = libraryStatusRepository.addBorrowedBook(bookName);

        assertThat(borrowedBook.size(), is(2));
        assertThat(borrowedBook.get(0), is(bookName2));
    }

    @Test
    void getLibraryStatus() {
        libraryStatusRepository.addNewBook(bookName);
        libraryStatusRepository.addNewBook(bookName2);
        libraryStatusRepository.addBorrowedBook(bookName2);

        LibraryStatus libraryStatus = libraryStatusRepository.getLibraryStatus();

        assertThat(libraryStatus.getTotalBooks(), is(2));
        assertThat(libraryStatus.getAvailableBooksCount(), is(1));
        assertThat(libraryStatus.getBorrowedBooksCount(), is(1));
    }
}