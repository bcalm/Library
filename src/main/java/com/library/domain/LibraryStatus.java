package com.library.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class LibraryStatus {

    private Integer totalBooks;
    private Integer borrowedBooksCount;
    private Integer availableBooksCount;
    private List<String> availableBooks;
    private List<String> borrowedBooks;
    private List<String> allBooks;
}
