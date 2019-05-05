package ru.petrovich.test.dcs.model.enums;

/**
 * Пол клиента.
 * Вынесен в enums для удобства расширения (привет, фейсбук!),
 * а также сохранения консистентности данных клиентов.
 */
public enum Sex {
    MALE("Мужской"),
    FEMALE("Женский");

    private String description;

    Sex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
