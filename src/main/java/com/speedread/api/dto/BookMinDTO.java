package com.speedread.api.dto;

import com.speedread.api.entities.Book;
import com.speedread.api.enums.BookState;

public class BookMinDTO {

    private Long id;
    private String name;
    private BookState state;

    public BookMinDTO() {
    }

    public BookMinDTO(Book entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookState getState() {
        return state;
    }
}
