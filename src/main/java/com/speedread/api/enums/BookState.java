package com.speedread.api.enums;

import java.util.Objects;


public enum BookState {
    SHELVED(0),
    READING(1),
    FINISHED(2);

    private final Integer code;

    BookState(Integer code) {
        this.code = code;
    }

    private Integer getCode() {
        return this.code;
    }

    public boolean canChangeTo(BookState state) {
        Integer currentCode = this.getCode();
        Integer targetCode = state.getCode();

        boolean canChange = !Objects.equals(currentCode, targetCode);
        if (targetCode == 0) {
            return canChange;
        }

        return canChange && targetCode - 1 == currentCode;
    }
}
