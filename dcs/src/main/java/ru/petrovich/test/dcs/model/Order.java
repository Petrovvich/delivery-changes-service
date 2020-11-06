package ru.petrovich.test.dcs.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.petrovich.test.dcs.model.enums.OrderState;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Простое представление заказа. Содержит минимальную информацию по самому заказу и ссылку на клиента.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order")
public class Order {

    /**
     * PK.
     * Уникальный идентификатор заказа в бд.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Номер заказа. Так как в ТЗ не задано принципа генерации номера заказа,
     * в это поле будет записываться текущее время в миллисекундах на момент создания заказа.
     */
    private Long number;
    /**
     * FK на {@link Client}
     */
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    /**
     * Обработан ли (доставлен) заказ.
     */
    @Column(name = "is_processed")
    private boolean isProcessed;

    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Builder
    public Order(Long number, Client client, boolean isProcessed, OrderState orderState) {
        this.number = number;
        this.client = client;
        this.isProcessed = isProcessed;
        this.orderState = orderState;
    }
}
