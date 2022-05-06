package com.library.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookModel {

    private Integer id;
    private String name;
}
