package com.alianza.clients.service;

import com.alianza.clients.entity.Client;
import com.alianza.clients.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@WebMvcTest(ClientService.class)
class ClientServiceTest {

    @MockBean
    private ClientRepository clientRepository;

    private ClientService clientService;
    
    @BeforeEach
    public void setup(){
        clientRepository = new ClientRepository();
        clientService = new ClientService(clientRepository);
    }

    @Test
    void getAll() throws Exception {
        List<Client> result = clientService.getAll();
        Assertions.assertNotNull(result);
    }

    @Test
    void saveClient() throws Exception {
        Client client = new Client(
                "Pepito Prueba",
                "prueba@gmail.com",
                3216548656L,
                "20/05/2019",
                "20/05/2019"
        );
        List<Client> result = clientService.saveClient(client);

        long count = result.stream().count();

        Client lastClient = result.stream().skip(count - 1).findFirst().get();

        Assertions.assertNotNull(lastClient.getShared_key());
        Assertions.assertNotNull(lastClient.getData_added());
        Assertions.assertEquals(lastClient.getName(), (client.getName()));
        Assertions.assertEquals(lastClient.getPhone(), (client.getPhone()));
        Assertions.assertEquals(lastClient.getEmail(), (client.getEmail()));
    }

    @Test
    void updateClient() throws Exception {
        Client client = new Client(
                "jgutierrez",
                "Pepito Prueba",
                "prueba@gmail.com",
                3216548656L,
                "20/02/2024",
                "20/05/2019",
                "20/05/2019"
        );
        List<Client> result = clientService.updateClient(client);

        long count = result.stream().count();

        Client lastClient = result.stream().skip(count - 1).findFirst().get();

        Assertions.assertEquals(lastClient.getName(), (client.getName()));
        Assertions.assertEquals(lastClient.getPhone(), (client.getPhone()));
        Assertions.assertEquals(lastClient.getEmail(), (client.getEmail()));
    }
}