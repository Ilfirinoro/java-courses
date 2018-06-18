package com.javacourse.clinic;

import com.javacourse.clinic.client.Client;
import com.javacourse.clinic.pet.Cat;
import com.javacourse.clinic.pet.Dog;
import com.javacourse.clinic.pet.Pet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ClinicTest {
    private final static String FIRST_CLIENT_ID = "cl1";
    private final static String SECOND_CLIENT_ID = "cl2";
    private final static String THIRD_CLIENT_ID = "cl3";
    private final static String FIRST_PET_NAME = "Thunder";
    private final static String SECOND_PET_NAME = "Storm";

    private Clinic getClinicForTest() {
        Clinic clinic = new Clinic();
        Pet catPat1 = new Cat(FIRST_PET_NAME);
        Pet catPat2 = new Cat(SECOND_PET_NAME);
        Pet catPat3 = new Dog(SECOND_PET_NAME);
        List<Client> clients = new ArrayList<>();
        clients.add(new Client(FIRST_CLIENT_ID, catPat1));
        clients.add(new Client(SECOND_CLIENT_ID, catPat2));
        clients.add(new Client(THIRD_CLIENT_ID, catPat3));
        clinic.addClients(clients);
        return clinic;
    }

    @Test
    public void addClient() {
        getClinicForTest();
    }

    @Test
    public void removeClient() {
        Clinic clinic = getClinicForTest();
        clinic.removeClient(FIRST_CLIENT_ID);
        clinic.removeClient(SECOND_CLIENT_ID);
    }

    @Test
    public void getClientById() {
        Clinic clinic = getClinicForTest();
        Client client1 = clinic.getClientById(FIRST_CLIENT_ID);
        Client client2 = clinic.getClientById(SECOND_CLIENT_ID);
        assertNotNull("Ошибка получения клиента по id " + FIRST_CLIENT_ID, client1);
        assertNotNull("Ошибка получения клиента по id " + SECOND_CLIENT_ID, client2);
    }

    @Test
    public void getClientByPetName() {
        Clinic clinic = getClinicForTest();

        Set<Client> clients1 = clinic.getClientByPetName(FIRST_PET_NAME);
        assertNotNull("Ошибка получения клиентов по имени питомца " + FIRST_PET_NAME, clients1);
        assertEquals("Должен был быть получен только один клиент", 1, clients1.size());
        assertEquals("Получен неверный клиент", clients1.iterator().next().getId(), FIRST_CLIENT_ID);

        Set<Client> clients2 = clinic.getClientByPetName(SECOND_PET_NAME);
        assertNotNull("Ошибка получения клиентов по имени питомца " + SECOND_PET_NAME, clients2);
        assertEquals("Должно было быть получено ровно два клиента", 2, clients2.size());

        boolean hasThird = false, hasSecond = false;
        for (Client client : clients2) {
            if (client.getId().equals(SECOND_CLIENT_ID)) {
                hasSecond = true;
            } else if (client.getId().equals(THIRD_CLIENT_ID)) {
                hasThird = true;
            }
        }
        assertTrue("Во второй выборке не найден клиент с id" + SECOND_CLIENT_ID, hasSecond);
        assertTrue("Во второй выборке не найден клиент с id" + THIRD_CLIENT_ID, hasThird);
    }

    @Test
    public void getAllClients() {
        Clinic clinic = getClinicForTest();
        assertEquals("ПОлучено неверное количество клиентов", 3, clinic.getAllClients().size());
    }
}