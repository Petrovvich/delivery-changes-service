package ru.petrovich.test.dcs.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Упрощенное представление задачи для обработки, например, колл-центром.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "task")
public class Task {

    /**
     * PK.
     * Уникальный идентификатор заявки в бд.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Дата и время создания заявки.
     */
    @Column
    private LocalDateTime created;
    /**
     * Дата и время обработки заявки.
     */
    @Column
    private LocalDateTime processed;
    /**
     * Номер заказа. Заполняется в ui.
     */
    @Column(name = "order_number")
    private Long orderNumber;
    /**
     * Флаг является ли задача задачей на перенос времени доставки груза.
     */
    @Column
    private boolean postponed;
    /**
     * Обработана ли заявка.
     */
    @Column(name = "has_processed")
    private boolean hasProcessed;

    @Builder

    public Task(LocalDateTime created, LocalDateTime processed, Long orderNumber, boolean postponed,
                boolean hasProcessed) {
        this.created = created;
        this.processed = processed;
        this.orderNumber = orderNumber;
        this.postponed = postponed;
        this.hasProcessed = hasProcessed;
    }
}
