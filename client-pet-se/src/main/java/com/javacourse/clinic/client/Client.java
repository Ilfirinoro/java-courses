package com.javacourse.clinic.client;

import com.javacourse.clinic.pet.Pet;

import java.util.Objects;

public class Client {
    private String id;
    private Pet pet;

    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    public String getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pet);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", pet=" + pet +
                '}';
    }
}
