package ru.petrovich.test.dcs.dao;

import ru.petrovich.test.dcs.model.Order;
import ru.petrovich.test.dcs.model.enums.OrderState;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс описания взаимодействия с сущностью заказа в бд.
 */
public interface OrderDao {
    public void createOrder(String number, Long client_id, boolean is_processed, OrderState order_state);

    public Optional<Order> getById(Long id);

    public List getAll();
}
