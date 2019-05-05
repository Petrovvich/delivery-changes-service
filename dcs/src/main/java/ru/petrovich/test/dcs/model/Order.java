package ru.petrovich.test.dcs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.petrovich.test.dcs.model.enums.OrderState;

/**
 * Простое представление заказа. Содержит минимальную информацию по самому заказу и ссылку на клиента.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    /**
     * PK.
     * Уникальный идентификатор заказа в бд.
     */
    private Long id;
    /**
     * Номер заказа. Так как в ТЗ не задано принципа генерации номера заказа,
     * в это поле будет записываться текущее время в миллисекундах на момент создания заказа.
     */
    private Long number;
    /**
     * FK на {@link Client}
     */
    private Long client_id;
    /**
     * Обработан ли (доставлен) заказ.
     */
    private boolean is_processed;

    private OrderState order_state;
}
