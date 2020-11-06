package ru.petrovich.test.dcs.service;

import ru.petrovich.test.dcs.model.Client;
/**
 * Сервис, описывающий все взаимодействиями с сущностью клиента.
 */
public interface ClientService {

    Client getClientById(Long id);
}
