package com.javacourse.clinic.pet;

public class Dog extends AbstractPet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Bark!";
    }
}
