package com.projectandtaskmanagement.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Urgency {
    IMPORTANT("Важные"),
    UNIMPORTANT("Неважные"),
    NEUTRAL("Нейтральные");

    private final String name;
}
