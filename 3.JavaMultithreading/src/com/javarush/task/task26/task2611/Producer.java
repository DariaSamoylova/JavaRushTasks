package com.javarush.task.task26.task2611;



import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mr_ma on 06.11.2017.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 1;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(String.valueOf(i), "Some text for " + i);
                i++;
                Thread.sleep(500);
                //  if (!map.isEmpty()) {
                // for (String key : map.keySet()) {
                //      System.out.println(map.remove(key));
                //  }
            }
        }  catch (Exception e){
            System.out.println("["+Thread.currentThread().getName()+"] thread was terminated");
        }

    }
}


/*В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ — счетчик начиная с 1, значение — фраза: «Some text for i» , пример «Some text for 1«.
2. при возникновении исключения выводить в консоль: «[TREAD_NAME] thread was terminated«, пример «[thread-1] thread was terminated«.

public class Consumer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Consumer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}
*/