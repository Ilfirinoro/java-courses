package com.javacourse.clinic.pet;

import java.util.Objects;
import java.util.UUID;

public abstract class AbstractPet implements Pet{
    private String name;
    private UUID uuid;

    public AbstractPet(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPet that = (AbstractPet) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, uuid);
    }

    @Override
    public String toString() {
        return "AbstractPet{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
