package com.speedread.api.dto;

import com.speedread.api.entities.Book;
import com.speedread.api.enums.BookState;

public class BookDTO {

    private Long id;
    private Long userId;
    private String name;
    private BookState state;

    public BookDTO() {
    }

    public BookDTO(Book entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.name = entity.getName();
        this.state = entity.getState();
    }

    public BookDTO(Long id, Long userId, String name, BookState state) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setState(BookState state) {
        this.state = state;
    }
}
