package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
   /* public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }) ;

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
              //  try {

                    //  solution.someMethodWithSynchronizedBlocks(o1,o2);
                      solution.someMethodWithSynchronizedBlocks(o2,o1);
                    //Thread.sleep(100);
              //  } catch (InterruptedException e) {
              //      e.printStackTrace();
              //  }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override

            public void run() {
                synchronized (o2) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }});


        t1.start();
        Thread.sleep(50);
        t2.start();
        Thread.sleep(50);
        t3.start();
        Thread.sleep(50);
if (t3.getState()== Thread.State.TERMINATED)
        return true;
else
    return false;
    }
*/

    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();
        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;
        synchronized (firstLock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            synchronized (secondLock) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception
    {
        new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }.start();

        Thread thread2=new Thread() {
            @Override
            public void run() {
                synchronized (o1)
                {
                    synchronized (o2)
                    {
                        solution.someMethodWithSynchronizedBlocks(o1, o2);
                    }
                }
            }
        };
        thread2.start();
        return Thread.State.BLOCKED.equals(thread2.getState());
    }

   
    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}

/*
Создаём 3 нити.
1 и 2 отвечают за мьютекс o1 и o2. 3 нить отвечает за вызов самого метода. В каждой нити я установил слип на полсекунды.
Запускаем 1 нить, слип на 50мс.
Запускаем 3 нить, которая вызывает метод. Слип на 50мс.
Запускаем 2 нить. Слип на 50мс.
Если эта вторая нить не в состоянии TIMED_WAITING, то false. Иначе true. То бишь если нить ожидает завершения другого потока, то она занята мьютексом 1-го объекта, и, следовательно, 1-й объект выше по иерархии.
Можно проверку по BLOCKED, но наоборот true - false будет. То есть если объект заблокирован, то его использует другая нить.
Сам не понял чё написал))))) Может кому поможет

Определяем порядок захвата монитора
Реализуй логику метода isNormalLockOrder, который должен определять:
соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks - порядку передаваемых в него аргументов.
В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
Если наоборот - false.


Требования:
1. Метод isNormalLockOrder должен возвращать true в случае, если синхронизация в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.
2. Метод isNormalLockOrder должен возвращать false в случае, если синхронизация в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
3. Метод isNormalLockOrder НЕ должен быть приватным.
4. Класс Solution НЕ должен быть объявлен с модификатором final.*/