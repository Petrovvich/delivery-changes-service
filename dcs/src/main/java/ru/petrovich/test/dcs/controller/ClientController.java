package ru.petrovich.test.dcs.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.service.ClientService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientServiceImpl;

    @GetMapping(value = "/{id}")
    public String getClientById(@PathVariable Long id) {
        log.info("Try to find client with id {}", id);
        Client client = clientServiceImpl.getClientById(id);
        log.debug("Found client {}", client);
        return "getClient";
    }
}
