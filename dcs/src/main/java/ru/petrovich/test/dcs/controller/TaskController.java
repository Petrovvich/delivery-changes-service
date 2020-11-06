package ru.petrovich.test.dcs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.petrovich.test.dcs.model.Task;
import ru.petrovich.test.dcs.service.impl.TaskServiceImpl;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "tasks/")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    @PostMapping
    public String createNew(@RequestParam Long number, Model model) {
        log.debug("Try to handle save request for id {}, model {}", number, model);
        taskServiceImpl.registerNew(number);

        model.addAttribute("status", "Сохранение прошло успешно");
        return "registerTask";
    }

    @GetMapping
    public String tasks(Model model) {
        log.debug("Try to handle get tasks request model {}", model);
        List<Task> tasks = taskServiceImpl.findAll();

        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping(path = "search/")
    public String search(@RequestParam Long orderNumber, Model model) {
        log.debug("Try to handle search request for id {}, model {}", orderNumber, model);

        List<Task> tasks = taskServiceImpl.findAllByNumber(orderNumber);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
