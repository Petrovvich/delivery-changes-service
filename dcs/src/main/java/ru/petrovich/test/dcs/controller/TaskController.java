package ru.petrovich.test.dcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.petrovich.test.dcs.service.TaskService;

import java.util.List;

@Controller
@RequestMapping(value = "tasks/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String createNew(@RequestParam Long number, Model model) {
        taskService.registerNew(number);

        model.addAttribute("status", "Сохранение прошло успешно");
        return "registerTask";
    }

    @GetMapping
    public String tasks(Model model) {
        List tasks = taskService.findAll();

        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping(value = "search/")
    public String search(@RequestParam Long search_input, Model model) {

        List tasks = taskService.findAllByNumber(search_input);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
