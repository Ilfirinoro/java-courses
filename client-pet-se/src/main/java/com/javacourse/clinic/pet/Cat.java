package com.javacourse.clinic.pet;

public class Cat extends AbstractPet {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return "Mew!";
    }

}
