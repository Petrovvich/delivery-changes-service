package ru.petrovich.test.dcs.dao;

import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.model.enums.Sex;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс описания взаимодействия с сущностью клиента в бд.
 */
public interface ClientDao {

    public void createClient(String last_name, String first_name, String middle_name, Sex sex);

    public Optional<Client> getById(Long id);

    public List getAll();
}
