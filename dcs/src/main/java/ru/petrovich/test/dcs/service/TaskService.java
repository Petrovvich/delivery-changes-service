package ru.petrovich.test.dcs.service;

import ru.petrovich.test.dcs.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task registerNew(Long taskNumber);

    List<Task> findAllUnprocessed();

    List<Task> findAllByNumber(Long number);
}
