package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            int y;
            while (true) {
               // y=i++;
                queue.put(String.valueOf(i++));
               // queue.put(String.valueOf(y));
              //  System.out.println("y="+y);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}