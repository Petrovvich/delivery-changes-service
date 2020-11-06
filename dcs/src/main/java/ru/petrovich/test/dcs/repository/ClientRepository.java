package ru.petrovich.test.dcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrovich.test.dcs.model.Client;

/**
 * Интерфейс описания взаимодействия с сущностью клиента в бд.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
