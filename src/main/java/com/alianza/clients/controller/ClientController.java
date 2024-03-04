package com.alianza.clients.controller;

import com.alianza.clients.entity.Client;
import com.alianza.clients.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/clients")
public class ClientController {

    final
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<Client> getAll() throws Exception {
        return this.clientService.getAll();
    }

    @PostMapping()
    public List<Client> saveClient(@RequestBody Client client) throws Exception {
        return this.clientService.saveClient(client);
    }

    @PutMapping()
    public List<Client> updateClient(@RequestBody Client client) throws Exception {
        return this.clientService.updateClient(client);
    }
}
