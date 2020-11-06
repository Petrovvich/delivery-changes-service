package ru.petrovich.test.dcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrovich.test.dcs.model.Order;

/**
 * Интерфейс описания взаимодействия с сущностью заказа в бд.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
