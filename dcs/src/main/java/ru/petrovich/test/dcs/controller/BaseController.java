package ru.petrovich.test.dcs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BaseController {
    @GetMapping(value = {"/", "/index", "index.html"})
    public String index() {
        log.debug("Handle index page request");
        return "registerTask";
    }
}
