package com.alianza.clients.repository;

import com.alianza.clients.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepository {

    List<Client> lista;

    public ClientRepository() {
        lista = new ArrayList<>();

        lista.add(new Client("jgutierrez",
                "Juliana Gutierrez",
                "jgutierrez@gmail.com",
                3219876543L,
                "20/05/2019",
                "20/05/2019",
                "20/05/2019"));

        lista.add(new Client("mmartinez",
                "Manuel Martinez",
                "mmartinez@gmail.com",
                3219876543L,
                "20/05/2019",
                "20/05/2019",
                "20/05/2019"));
    }

    public Client findBySharedKey(String shared_key) throws Exception {
        return lista.stream().filter(v -> Objects.equals(v.getShared_key(), shared_key)).findFirst().get();
    }

    public List<Client> getAll() throws Exception{
        return this.lista;
    }

    public List<Client> saveClient(Client client, String shared_key, String date_added) throws Exception{

        lista.add(new Client(
                shared_key,
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                date_added,
                client.getStart_date(),
                client.getEnd_date()));

        return this.lista;
    }

    public void deleteClient(Client client) throws Exception {
        lista.remove(client);
    }
}
