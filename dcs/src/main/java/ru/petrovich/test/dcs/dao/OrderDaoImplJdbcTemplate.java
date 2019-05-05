package ru.petrovich.test.dcs.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.petrovich.test.dcs.mappers.OrderMapper;
import ru.petrovich.test.dcs.model.Order;
import ru.petrovich.test.dcs.model.enums.OrderState;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Имплементация для jdbc template интерфейса взаимодействия с сущностью заказа в бд
 */
@Slf4j
public class OrderDaoImplJdbcTemplate implements OrderDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT = "INSERT INTO Orders (number, client_id, is_processed, order_state) VALUES (?,?,?,?)";
    private final String SQL_GET_BY_ID = "SELECT * FROM Orders WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM Orders";

    public OrderDaoImplJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createOrder(String number, Long client_id, boolean is_processed, OrderState order_state) {
        try {
            jdbcTemplate.update(SQL_INSERT, number, client_id, is_processed, order_state);
            log.info("Saving order: {} {} {} {} into db. Success.", number, client_id, is_processed, order_state);
        } catch (Exception e) {
            log.error("Can't save order in db cause {}", e);
        }
    }

    @Override
    public Optional<Order> getById(Long id) {
        Optional<Order> order = Optional.empty();
        try {
            jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new OrderMapper());
            log.info("Try to find client with id {}, result: {}", id, order);
        } catch (Exception e) {
            log.error("Can't find order in db with ");
        }
        return order;
    }

    @Override
    public List getAll() {
        List orders = Collections.emptyList();
        try {
            orders = jdbcTemplate.query(SQL_FIND_ALL, new OrderMapper());
            log.info("Try to find all orders, found {}", orders.size());
        } catch (Exception e) {
            log.error("Can't find all orders in db cause {}", e);
        }
        return orders;
    }
}
