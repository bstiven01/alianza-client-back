package com.alianza.clients.service;

import com.alianza.clients.entity.Client;
import com.alianza.clients.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientService {

    private final static Logger LOGGER = Logger.getLogger("");

    final
    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() throws Exception {
        try {
            LOGGER.log(Level.INFO, "Clients found");
            return this.clientRepository.getAll();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Clients not found " + e.getMessage());
            throw new Exception("Clients not found : " + e.getMessage() + ". Not found");
        }

    }

    public List<Client> saveClient(Client client) throws Exception {
        try {
            LOGGER.log(Level.INFO, "Client received to save " + client.toString());

            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());

            String[] parts = client.getEmail().split("@");

            return this.clientRepository.saveClient(client, parts[0], date);

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Client not save " + e.getMessage());
            throw new Exception("Client not save : " + e.getMessage());
        }
    }

    public List<Client> updateClient(Client client) throws Exception {
        try {

            LOGGER.log(Level.INFO, "Client received to update " + client.toString());

            Client client_found = this.clientRepository.findBySharedKey(client.getShared_key());

            this.clientRepository.deleteClient(client_found);

            client_found.setName(client.getName());
            client_found.setEmail(client.getEmail());
            client_found.setPhone(client.getPhone());
            client_found.setStart_date(client.getStart_date());
            client_found.setEnd_date(client.getEnd_date());

            return this.clientRepository.saveClient(client_found, client_found.getShared_key(), client_found.getData_added());

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Client not update " + e.getMessage());
            throw new Exception("Client not update : " + e.getMessage());
        }
    }

}
