package ru.petrovich.test.dcs.dao;

import ru.petrovich.test.dcs.model.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс описания взаимодействия с сущностью заявки на обработку в бд.
 */
public interface TaskDao {
    public void createTask(Date created, Date processed, Long order_number, boolean is_postponed, boolean is_processed);

    public Optional<Task> getById(Long id);

    public List getAll();
}
