package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class BookModel {

    private Integer id;
    private String name;
    private boolean isBorrowed;

    public BookModel(Integer id, String name, boolean isBorrowed) {
        this.id = id;
        this.name = name;
        this.isBorrowed = isBorrowed;
    }
}
