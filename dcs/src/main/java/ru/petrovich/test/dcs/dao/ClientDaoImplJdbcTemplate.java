package ru.petrovich.test.dcs.dao;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.petrovich.test.dcs.mappers.ClientMapper;
import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.model.enums.Sex;

import javax.sql.DataSource;
import java.util.List;

/**
 * Имплементация для jdbc template интерфейса взаимодействия с сущностью клиента в бд
 */
@Slf4j
public class ClientDaoImplJdbcTemplate implements ClientDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImplJdbcTemplate.class);
    private final String SQL_INSERT = "INSERT INTO Client (last_name, first_name, middle_name, sex) VALUES (?,?,?,?)";
    private final String SQL_GET_BY_ID = "SELECT * FROM Client WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM Client";

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createClient(String last_name, String first_name, String middle_name, Sex sex) {
        jdbcTemplate.update(SQL_INSERT, last_name, first_name, middle_name, sex);
        logger.info("Saving client: {} {} {} {} into db. Success.", last_name, first_name, middle_name, sex);
    }

    @Override
    public Client getById(Long id) {
        Client client = jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new ClientMapper());
        logger.info("Try to find client with id {}", id);
        return client;
    }

    @Override
    public List getAll() {
        List clients = jdbcTemplate.query(SQL_FIND_ALL, new ClientMapper());
        logger.info("Try to find all clients");
        return clients;
    }
}
