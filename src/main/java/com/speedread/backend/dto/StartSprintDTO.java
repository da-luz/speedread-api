package com.speedread.backend.dto;

public class StartSprintDTO {
    private Long bookId;

    public StartSprintDTO() {
    }

    public StartSprintDTO(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
