package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() throws InterruptedException {
        while (!isValuePresent){
            wait();
        }
        notifyAll();
        System.out.println("Got: " + value);
        isValuePresent=false;
        return value;
    }

    public synchronized void put(int value) throws InterruptedException {
        while (isValuePresent) {
            wait();
        }
        notifyAll();
        this.value = value;
        isValuePresent=true;
        System.out.println("Put: " + value);
    }
}
/*3. Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
4. Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того, как оно пропадет.
5. Метод get класса TransferObject должен устанавливать флаг isValuePresent в false и уведомлять другие нити ожидающие освобождения монитора перед возвратом значение поля value.
6. Метод put класса TransferObject должен устанавливать флаг isValuePresent в true и уведомлять другие нити ожидающие освобождения монитора после обновления значение поля value.*/