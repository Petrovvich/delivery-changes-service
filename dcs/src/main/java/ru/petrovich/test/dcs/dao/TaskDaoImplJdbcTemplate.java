package ru.petrovich.test.dcs.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.petrovich.test.dcs.mappers.TaskMapper;
import ru.petrovich.test.dcs.model.Task;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class TaskDaoImplJdbcTemplate implements TaskDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImplJdbcTemplate.class);
    private final String SQL_INSERT = "INSERT INTO Tasks (created, processed, order_number, is_postponed, is_processed) VALUES (?,?,?,?)";
    private final String SQL_GET_BY_ID = "SELECT * FROM Tasks WHERE id = ?";
    private final String SQL_FIND_ALL = "SELECT * FROM Tasks";

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createTask(Date created, Date processed, Long order_number, boolean is_postponed, boolean is_processed) {
        jdbcTemplate.update(SQL_INSERT, created, processed, order_number, is_postponed, is_processed);
        logger.info("Saving task: {} {} {} {} {} into db. Success.", created, processed, order_number, is_postponed, is_processed);
    }

    @Override
    public Task getById(Long id) {
        Task task = jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[]{id}, new TaskMapper());
        logger.info("Try to find task with id {}", id);
        return task;
    }

    @Override
    public List getAll() {
        List tasks = jdbcTemplate.query(SQL_FIND_ALL, new TaskMapper());
        logger.info("Try to find all tasks");
        return tasks;
    }
}
