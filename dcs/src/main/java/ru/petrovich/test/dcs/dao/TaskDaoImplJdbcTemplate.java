package ru.petrovich.test.dcs.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.petrovich.test.dcs.mappers.TaskMapper;
import ru.petrovich.test.dcs.model.Task;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Имплементация для jdbc template интерфейса взаимодействия с сущностью задачи в бд
 */
@Slf4j
public class TaskDaoImplJdbcTemplate implements TaskDao {
    private JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT = "INSERT INTO Tasks (created, processed, order_number, is_postponed, hasProcessed) VALUES (?,?,?,?,?)";
    private final String SQL_GET_BY_ID = "SELECT * FROM Tasks WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM Tasks";
    private final String SQL_FIND_ALL_UNPROCESSED = "SELECT * FROM Tasks WHERE NOT hasProcessed";
    private final String SQL_FIND_BY_NUMBER = "SELECT * FROM Tasks WHERE order_number = ?";

    public TaskDaoImplJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createTask(Date created, Date processed, Long order_number, boolean is_postponed, boolean is_processed) {
        try {
            jdbcTemplate.update(SQL_INSERT, created, processed, order_number, is_postponed, is_processed);
            log.info("Saving task: {} {} {} {} {} into db. Success.", created, processed, order_number, is_postponed, is_processed);
        } catch (Exception e) {
            log.error("Can't saving task: {} {} {} {} {} into db cause {}", created, processed, order_number, is_postponed, is_processed, e);
        }
    }

    @Override
    public Optional<Task> getById(Long id) {
        Optional<Task> task = Optional.empty();
        try {
            task = Optional.ofNullable(jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new TaskMapper()));
            log.info("Try to find task with id {}", id);
        } catch (Exception e) {
            log.error("Can't find any tasks in db with id {} cause {}", id, e);
        }
        return task;
    }

    @Override
    public List getAll() {
        List tasks = Collections.emptyList();
        try {
            tasks = jdbcTemplate.query(SQL_FIND_ALL, new TaskMapper());
            log.info("Try to find all tasks, found: {}", tasks.size());
        } catch (Exception e) {
            log.error("Can't find any tasks in db cause {}", e);
        }
        return tasks;
    }

    public List findAllNotProcessed() {
        List tasks = Collections.emptyList();
        try {
            tasks = jdbcTemplate.query(SQL_FIND_ALL_UNPROCESSED, new TaskMapper());
        } catch (Exception e) {
            log.error("Can't find any unprocessed tasks in db cause {}", e);
        }
        return tasks;
    }

    public List findByNumber(Long number) {
        List tasks = Collections.emptyList();
        try {
            tasks = jdbcTemplate.query(SQL_FIND_BY_NUMBER, new Object[]{number}, new TaskMapper());
        } catch (Exception e) {
            log.error("Can't find tasks with number: {}, cause: {}", number, e);
        }
        return tasks;
    }
}
