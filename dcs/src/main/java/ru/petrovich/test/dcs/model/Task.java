package ru.petrovich.test.dcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * Упрощенное представление задачи для обработки, например, колл-центром.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    /**
     * PK.
     * Уникальный идентификатор заявки в бд.
     */
    private Long id;
    /**
     * Дата и время создания заявки.
     */
    private Date created;
    /**
     * Дата и время обработки заявки.
     */
    private Date processed;
    /**
     * Номер заказа. Заполняется в ui.
     */
    private Long order_number;
    /**
     * Флаг является ли задача задачей на перенос времени доставки груза.
     */
    private boolean is_postponed;
    /**
     * Обработана ли заявка.
     */
    private boolean hasProcessed;
}
