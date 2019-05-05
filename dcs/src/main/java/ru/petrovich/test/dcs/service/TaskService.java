package ru.petrovich.test.dcs.service;

import org.springframework.stereotype.Service;
import ru.petrovich.test.dcs.config.SpringJdbcConfig;
import ru.petrovich.test.dcs.dao.TaskDaoImplJdbcTemplate;
import ru.petrovich.test.dcs.model.Task;

import java.util.Date;
import java.util.List;

/**
 * Сервис, описывающий все взаимодействиями с сущностью заявки на обработку.
 */
@Service
public class TaskService {

    private TaskDaoImplJdbcTemplate taskDaoImplJdbcTemplate;

    public TaskService(SpringJdbcConfig config) {
        this.taskDaoImplJdbcTemplate = new TaskDaoImplJdbcTemplate(config.mysqlDataSource());
    }

    public List<Task> findAll() {
        List result = taskDaoImplJdbcTemplate.getAll();
        return result;
    }

    public void registerNew(Long number) {
        taskDaoImplJdbcTemplate.createTask(new Date(), null, number, true, false);
    }

    public List<Task> findAllUnprocessed() {
        List result = taskDaoImplJdbcTemplate.findAllNotProcessed();
        return result;
    }

    public List<Task> findAllByNumber(Long number) {
        List result = taskDaoImplJdbcTemplate.findByNumber(number);
        return result;
    }
}
