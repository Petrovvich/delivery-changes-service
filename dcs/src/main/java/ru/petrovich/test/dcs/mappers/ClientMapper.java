package ru.petrovich.test.dcs.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.model.enums.Sex;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер результата выборки из набора полей в сущность клиента.
 */
public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("id"));
        client.setFirst_name(rs.getString("first_name"));
        client.setLast_name(rs.getString("last_name"));
        client.setMiddle_name(rs.getString("middle_name"));
        client.setSex(Sex.valueOf(rs.getString("sex")));
        return client;
    }
}
