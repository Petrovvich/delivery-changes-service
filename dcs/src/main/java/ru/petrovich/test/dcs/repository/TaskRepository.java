package ru.petrovich.test.dcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrovich.test.dcs.model.Task;

import java.util.List;

/**
 * Интерфейс описания взаимодействия с сущностью заявки на обработку в бд.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByHasProcessed(boolean hasProcessed);
    List<Task> findAllByOrderNumber(Long orderNumber);
}
