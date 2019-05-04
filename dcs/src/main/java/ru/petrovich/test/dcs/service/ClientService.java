package ru.petrovich.test.dcs.service;

import org.springframework.stereotype.Service;
import ru.petrovich.test.dcs.config.SpringJdbcConfig;
import ru.petrovich.test.dcs.dao.ClientDaoImplJdbcTemplate;
import ru.petrovich.test.dcs.model.Client;

@Service
public class ClientService {

    private SpringJdbcConfig config;
    private ClientDaoImplJdbcTemplate clientDaoImplJdbcTemplate;

    public ClientService(SpringJdbcConfig config) {
        this.config = config;
        this.clientDaoImplJdbcTemplate = new ClientDaoImplJdbcTemplate();
        clientDaoImplJdbcTemplate.setDataSource(config.mysqlDataSource());
    }

    public Client getClientById(Long id) {

        Client result = clientDaoImplJdbcTemplate.getById(id);

        return result;
    }
}
