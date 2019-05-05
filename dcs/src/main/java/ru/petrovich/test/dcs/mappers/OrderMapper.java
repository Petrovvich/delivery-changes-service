package ru.petrovich.test.dcs.mappers;


import org.springframework.jdbc.core.RowMapper;
import ru.petrovich.test.dcs.model.Order;
import ru.petrovich.test.dcs.model.enums.OrderState;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер результата выборки из набора полей в сущность заказа.
 */
public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setNumber(rs.getLong("number"));
        order.setClient_id(rs.getLong("client_id"));
        order.set_processed(rs.getBoolean("is_processed"));
        order.setOrder_state(OrderState.valueOf(rs.getString("order_state")));
        return order;
    }
}
