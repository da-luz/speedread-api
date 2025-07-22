package com.speedread.backend.dto;

import com.speedread.backend.enums.BookState;

public class FinishSprintDTO {
    private BookState finalState;

    public FinishSprintDTO() {
    }

    public FinishSprintDTO(BookState finalState) {
        this.finalState = finalState;
    }

    public BookState getFinalState() {
        return finalState;
    }

    public void setFinalState(BookState finalState) {
        this.finalState = finalState;
    }
}
