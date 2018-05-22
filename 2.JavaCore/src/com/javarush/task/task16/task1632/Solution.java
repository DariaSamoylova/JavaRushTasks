package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
static {
    threads.add(new N1());
    threads.add(new N2());
    threads.add(new N3());
    threads.add(new N4());
    threads.add(new N5());
}
    public static void main(String[] args) {
    }

    public static  class N1 extends Thread{
        public void run(){
            while(true);
        }

    }
    public static class N2 extends Thread{
        public void run(){
           try{
                Thread.sleep(0);
           } catch (InterruptedException r){
               System.out.println("InterruptedException");
           }
        }

    }
    public static class N3 extends Thread{

        public void run(){
            try{
               while(true) {

                    System.out.println("Ура");
                   Thread.sleep(500);
                }
            } catch (InterruptedException r){

            }
        }
    }
    public static class N4 extends Thread implements Message{
        public void showWarning(){
           if ( N4.currentThread().isAlive())
               N4.currentThread().interrupt();
        }


        public void run(){
           // try{
                //    while(true) {
              //  Thread.sleep(500);
              //  System.out.println("Ура");
                //    }
          //  } catch (InterruptedException r){

          //  }
        }
    }
    public static class N5 extends Thread{
BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        public void run(){
            String s="";
            int sum=0;
            try {
            while (true){
                s=r.readLine();
               if (s.equals("N")) break;
                sum=sum+Integer.parseInt(s);
            }
            System.out.println(sum);
            } catch (IOException e) {
              //  e.printStackTrace();
            }
            // try{
            //    while(true) {
            //  Thread.sleep(500);
            //  System.out.println("Ура");
            //    }
            //  } catch (InterruptedException r){

            //  }
        }
    }
}

/*Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить «InterruptedException» при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить «Ура«;
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово «N«, а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()


Требования:
1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.*/