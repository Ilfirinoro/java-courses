package com.javacourse.concurent;

public class Counter {

    private int amount;

    public synchronized int increase() {
        this.amount++;
        return amount;
    }

    public int getAmount() {
        return amount;
    }
}
