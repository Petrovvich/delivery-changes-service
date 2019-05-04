package ru.petrovich.test.dcs.dao;

import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.model.enums.Sex;

import javax.sql.DataSource;
import java.util.List;

/**
 * Интерфейс описания взаимодействия с сущностью клиента в бд.
 */
public interface ClientDao {
    public void setDataSource(DataSource dataSource);

    public void createClient(String last_name, String first_name, String middle_name, Sex sex);

    public Client getById(Long id);

    public List getAll();
}
