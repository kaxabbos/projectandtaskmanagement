package com.projectandtaskmanagement.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    LONG_TERM("Долгосрочные"),
    SHORT_TERM("Краткосрочные");

    private final String name;
}
