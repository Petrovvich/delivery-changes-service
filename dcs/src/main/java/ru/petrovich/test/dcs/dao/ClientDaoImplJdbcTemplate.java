package ru.petrovich.test.dcs.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.petrovich.test.dcs.mappers.ClientMapper;
import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.model.enums.Sex;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Имплементация для jdbc template интерфейса взаимодействия с сущностью клиента в бд
 */
@Slf4j
public class ClientDaoImplJdbcTemplate implements ClientDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT = "INSERT INTO Client (last_name, first_name, middle_name, sex) VALUES (?,?,?,?)";
    private final String SQL_GET_BY_ID = "SELECT * FROM Client WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM Client";


    public ClientDaoImplJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createClient(String last_name, String first_name, String middle_name, Sex sex) {
        try {
            jdbcTemplate.update(SQL_INSERT, last_name, first_name, middle_name, sex);
            log.info("Saving client: {} {} {} {} into db. Success.", last_name, first_name, middle_name, sex);
        } catch (Exception e) {
            log.error("Can't saving task: {} {} {} {} into db cause {}", last_name, first_name, middle_name, sex, e);
        }
    }

    @Override
    public Optional<Client> getById(Long id) {
        Optional<Client> client = Optional.empty();
        try {
            client = Optional.ofNullable(jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new ClientMapper()));
            log.info("Try to find client with id {}", id);
        } catch (Exception e) {
            log.error("Can't find any clients in db with id {} cause {}", id, e);
        }
        return client;
    }

    @Override
    public List getAll() {
        List clients = Collections.emptyList();
        try {
            clients = jdbcTemplate.query(SQL_FIND_ALL, new ClientMapper());
            log.info("Try to find all clients, found {}", clients.size());
        } catch (Exception e) {
            log.error("Can't find any clients in db cause {}", e);
        }
        return clients;
    }
}
