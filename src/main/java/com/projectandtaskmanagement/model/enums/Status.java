package com.projectandtaskmanagement.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    FINISH("Выполнено"),
    WAITING("Ожидание"),
    IN_PROGRESS("В процессе");

    private final String name;
}
