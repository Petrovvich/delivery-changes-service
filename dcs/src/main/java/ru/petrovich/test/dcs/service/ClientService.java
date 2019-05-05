package ru.petrovich.test.dcs.service;

import org.springframework.stereotype.Service;
import ru.petrovich.test.dcs.config.SpringJdbcConfig;
import ru.petrovich.test.dcs.dao.ClientDaoImplJdbcTemplate;
import ru.petrovich.test.dcs.model.Client;

/**
 * Сервис, описывающий все взаимодействиями с сущностью клиента.
 */
@Service
public class ClientService {

    private ClientDaoImplJdbcTemplate clientDaoImplJdbcTemplate;

    public ClientService(SpringJdbcConfig config) {
        this.clientDaoImplJdbcTemplate = new ClientDaoImplJdbcTemplate(config.mysqlDataSource());
    }

    public Client getClientById(Long id) {
        return clientDaoImplJdbcTemplate.getById(id).orElse(null);
    }
}
