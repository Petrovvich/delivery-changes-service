package ru.petrovich.test.dcs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.petrovich.test.dcs.service.ClientService;

@Controller
@Slf4j
@RequestMapping("clients/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "getById/{id}", method = RequestMethod.GET)
    public String getClientById(@PathVariable Long id) {
        log.info("Try to find client with id {}", id);
        clientService.getClientById(id);
        return "getClient";
    }
}
