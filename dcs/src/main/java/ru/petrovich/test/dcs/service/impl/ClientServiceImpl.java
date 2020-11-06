package ru.petrovich.test.dcs.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.petrovich.test.dcs.model.Client;
import ru.petrovich.test.dcs.repository.ClientRepository;
import ru.petrovich.test.dcs.service.ClientService;

/**
 * @see ClientService
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public Client getClientById(Long id) {
        log.debug("Try to find client by id {}", id);
        return clientRepository.findById(id).orElse(null);
    }
}
