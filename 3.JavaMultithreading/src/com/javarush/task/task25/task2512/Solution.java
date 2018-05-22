package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        //   t.getStackTrace();
        //  System.out.println(e.getMessage());
        ArrayList<Throwable> arr = new ArrayList<>();
        arr.add(e);
        while (true) {
            Throwable q = e.getCause();
            if (q == null) break;
            arr.add(q);
            e = e.getCause();
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            System.out.println(arr.get(i));
        }
        //   System.out.println(e.getCause().getCause());
        // //  StackTraceElement[] eee = e.getStackTrace();
        //   for(StackTraceElement r:eee) {
        //       System.out.println(r.toString()+": ");
        //  }
    }

    public static void main(String[] args) {
     /*    Sss s = new Sss();
         Solution sol = new Solution();
         s.setUncaughtExceptionHandler(sol);
         s.start();
         sol.uncaughtException(s,new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
*/
    }

}

/*
class Sss extends Thread{
    @Override
    public void run() {
        int t = 1/0;
      //  try {
          //  rrr();
       // } catch (Exception e) {
        //    throw e;
       // }
    }


   // public void rrr() throws Exception {
   //     throw  new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
   // }
}(/)*/

/*Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.
   cv
Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC


Требования:
1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
4. Сообщения должны выводиться в формате "exception class : exception message".*/