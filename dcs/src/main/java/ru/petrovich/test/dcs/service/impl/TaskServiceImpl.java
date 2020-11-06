package ru.petrovich.test.dcs.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.petrovich.test.dcs.model.Task;
import ru.petrovich.test.dcs.repository.TaskRepository;
import ru.petrovich.test.dcs.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сервис, описывающий все взаимодействиями с сущностью заявки на обработку.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findAll() {
        log.debug("Try to find all tasks");
        return taskRepository.findAll();
    }

    public Task registerNew(Long taskNumber) {
        log.debug("Try to create task with number {}", taskNumber);
        return taskRepository.save(Task.builder()
                .created(LocalDateTime.now())
                .orderNumber(taskNumber)
                .build());
    }

    public List<Task> findAllUnprocessed() {
        log.debug("Try to find all unprocessed tasks");
        return taskRepository.findAllByHasProcessed(false);
    }

    public List<Task> findAllByNumber(Long orderNumber) {
        log.debug("Try to find all tasks by order number {}", orderNumber);
        return taskRepository.findAllByOrderNumber(orderNumber);
    }
}
