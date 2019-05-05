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
        task.setCreated(rs.getTimestamp("created"));
        task.setProcessed(rs.getTimestamp("processed"));
        task.setOrder_number(rs.getLong("order_number"));
        task.set_postponed(rs.getBoolean("is_postponed"));
        task.setHasProcessed(rs.getBoolean("hasProcessed"));
        return task;
    }
}
