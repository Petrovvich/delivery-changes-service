package ru.petrovich.test.dcs.dao;

import ru.petrovich.test.dcs.model.Task;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

/**
 * Интерфейс описания взаимодействия с сущностью заявки на обработку в бд.
 */
public interface TaskDao {
    public void setDataSource(DataSource dataSource);

    public void createTask(Date created, Date processed, Long order_number, boolean is_postponed, boolean is_processed);

    public Task getById(Long id);

    public List getAll();
}
