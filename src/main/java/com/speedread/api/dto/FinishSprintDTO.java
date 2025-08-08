package com.speedread.api.dto;

import com.speedread.api.enums.BookState;

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
