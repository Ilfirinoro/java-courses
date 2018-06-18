package com.javacourse.clinic.client.aggregate;

import com.javacourse.clinic.client.Client;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientIndex {
    private final Map<String, Client> clientByIdAggregate;
    private final AggregateByNotUnique<String, Client> clientByPetNameAggregate;

    public ClientIndex() {
        clientByIdAggregate = new ConcurrentHashMap<>();
        clientByPetNameAggregate = new AggregateByNotUnique<>();
    }

    public void add(Client client) {
        clientByIdAggregate.put(client.getId(), client);
        clientByPetNameAggregate.put(client.getPet().getName(), client);
    }

    public boolean remove(String clientId) {
        if(!clientByIdAggregate.containsKey(clientId)) {
            return false;
        }
        Client clientToRemove = clientByIdAggregate.remove(clientId);
        return clientByPetNameAggregate.remove(
                clientToRemove.getPet().getName(),
                clientToRemove);
    }

    public Client getClientById(String id) {
        return clientByIdAggregate.get(id);
    }

    public Set<Client> getClientByPetName(String petName) {
        return clientByPetNameAggregate.get(petName);
    }

    public Set<Client> getAllClients() {
        return new HashSet(clientByIdAggregate.values());
    }
}
