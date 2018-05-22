package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    Thread th;
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        }
    }
       // System.out.println(Thread.currentThread().getName());
      /*  System.out.println(th.getName());
        try {

            Thread.sleep(100);


        } catch (InterruptedException e) {
           th.run();
            //  e.printStackTrace();
        }
    }*/
   /*   System.out.println(Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }
*/

    @Override
    public void start(String threadName) {
        System.out.println(threadName);
     //   th = Thread.currentThread();
        th =new Thread(this);

        th.setName(threadName);
       // System.out.println("ggg=");
        th.start();
      ///  System.out.println("fff=");
    }

    @Override
    public void stop() {
//if (th.getName().equals("fifth"))
    th.interrupt();
    }
}
