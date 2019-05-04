package ru.petrovich.test.dcs.dao;

import ru.petrovich.test.dcs.model.Order;
import ru.petrovich.test.dcs.model.enums.OrderState;

import javax.sql.DataSource;
import java.util.List;

/**
 * Интерфейс описания взаимодействия с сущностью заказа в бд.
 */
public interface OrderDao {
    public void setDataSource(DataSource dataSource);

    public void createOrder(String number, Long client_id, boolean is_processed, OrderState order_state);

    public Order getById(Long id);

    public List getAll();
}
