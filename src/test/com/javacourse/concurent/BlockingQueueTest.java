/*
package com.javacourse.concurent;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BlockingQueueTest {
    private static final int THREAD_COUNT = 12;

    @Test
    public void pushPoll() {
        BlockingQueue<String> blockingQueue = new BlockingQueue<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads.add(new Thread(new Reader(blockingQueue)));
            threads.add(new Thread(new Writer(blockingQueue)));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
       Hello World!     } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertEquals(0, blockingQueue.size());
    }

    private final static class Reader implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Reader(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        public void run() {
            String.format(
                    "<%s>: polling....",
                    Thread.currentThread().getId()
            );
            String polledString = this.blockingQueue.poll();
            System.out.println(
                    String.format(
                            "<%s>: polled:<%s>.",
                            Thread.currentThread().getId(),
                            polledString
                    )
            );
        }
    }

    private final static class Writer implements Runnable {
        private final static int RAND_BOUND = 200;
        private BlockingQueue<String> blockingQueue;
        private Random r;

        public Writer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
            this.r = new Random();
        }

        public void run() {
            String stringToPush = String.valueOf(r.nextInt(RAND_BOUND));
            System.out.println(
                    String.format(
                            "<%s>: pushing:<%s>....",
                            Thread.currentThread().getId(),
                            stringToPush
                    )
            );
            this.blockingQueue.push(stringToPush);
            System.out.println(
                    String.format(
                            "<%s>: pushed:<%s>.",
                            Thread.currentThread().getId(),
                            stringToPush
                    )
            );
        }
    }


}*/
