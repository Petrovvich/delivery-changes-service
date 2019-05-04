package ru.petrovich.test.dcs.model.enums;

/**
 * Статус обработки заказа.
 */
public enum OrderState {
    /**
     * Промежуточный статус.
     * Заказ только что создан, заказу присвоен номер, заказ сохранен в бд.
     */
    NEW("Новый", 0),
    /**
     * Промежуточный статус.
     * Заказ готов к обаботке колл-центром/курьером
     */
    READY_TO_PROCESSING("Готов к обработке", 1),
    /**
     * Финальный статус.
     * Заказ доставлен получателю / возвращен отправителю
     */
    PROCESSED("Обработан", 2);

    private String description;
    private Integer status_code;

    OrderState(String description, Integer status_code) {
        this.description = description;
        this.status_code = status_code;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus_code() {
        return status_code;
    }
}
