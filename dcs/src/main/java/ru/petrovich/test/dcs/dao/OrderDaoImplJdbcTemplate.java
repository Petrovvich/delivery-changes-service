package ru.petrovich.test.dcs.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.petrovich.test.dcs.mappers.OrderMapper;
import ru.petrovich.test.dcs.model.Order;
import ru.petrovich.test.dcs.model.enums.OrderState;

import javax.sql.DataSource;
import java.util.List;

/**
 * Имплементация для jdbc template интерфейса взаимодействия с сущностью заказа в бд
 */
public class OrderDaoImplJdbcTemplate implements OrderDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(OrderDaoImplJdbcTemplate.class);
    private final String SQL_INSERT = "INSERT INTO Orders (number, client_id, is_processed, order_state) VALUES (?,?,?,?)";
    private final String SQL_GET_BY_ID = "SELECT * FROM Orders WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM Orders";

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createOrder(String number, Long client_id, boolean is_processed, OrderState order_state) {
        jdbcTemplate.update(SQL_INSERT, number, client_id, is_processed, order_state);
        logger.info("Saving client: {} {} {} {} into db. Success.", number, client_id, is_processed, order_state);
    }

    @Override
    public Order getById(Long id) {
        Order order = jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new OrderMapper());
        logger.info("Try to find client with id {}, result: {}", id, order);
        return order;
    }

    @Override
    public List getAll() {
        List clients = jdbcTemplate.query(SQL_FIND_ALL, new OrderMapper());
        logger.info("Try to find all clients");
        return clients;
    }
}
