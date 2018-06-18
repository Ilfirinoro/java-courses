package com.javacourse.concurent;

import java.util.LinkedList;

public class BlockingQueue<T> {
    private final LinkedList<T> queue = new LinkedList<T>();

    public void push(T obj) {
        synchronized (this.queue) {
            this.queue.add(obj);
            this.queue.notifyAll();
        }
    }

    public T poll() {
        synchronized (this.queue) {
            while(this.queue.isEmpty()) {
                try {
                    this.queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.queue.remove();
        }
    }

    public int size() {
        return this.queue.size();
    }
}
