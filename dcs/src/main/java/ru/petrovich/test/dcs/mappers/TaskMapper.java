package ru.petrovich.test.dcs.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.petrovich.test.dcs.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер результата выборки из набора полей в сущность заявки на обработку.
 */
public class TaskMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setCreated(rs.getDate("created"));
        task.setProcessed(rs.getDate("processed"));
        task.setOrder_number(rs.getLong("order_number"));
        task.set_postponed(rs.getBoolean("is_postponed"));
        task.set_processed(rs.getBoolean("is_processed"));
        return task;
    }
}
