package com.javacourse.clinic;

import com.javacourse.clinic.client.Client;
import com.javacourse.clinic.client.aggregate.ClientIndex;

import java.util.Collection;
import java.util.Set;

public class Clinic {
    private final ClientIndex clientIndex;

    public Clinic() {
        clientIndex = new ClientIndex();
    }

    public void addClients(Collection<Client> clients) {
        for(Client client : clients) {
            clientIndex.add(client);
        }
    }

    public void addClient(Client client) {
        clientIndex.add(client);
    }

    public boolean removeClient(String clientId) {
        return clientIndex.remove(clientId);
    }


    public Client getClientById(String id) {
        return clientIndex.getClientById(id);
    }

    public Set<Client> getClientByPetName(String petName) {
        return clientIndex.getClientByPetName(petName);
    }

    public Set<Client> getAllClients() {
        return clientIndex.getAllClients();
    }
}
