package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by mr_ma on 25.05.2018.
 */
public class Waiter implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg + " was cooked by " + o);
    }
}
/*4.1. Установим флаг setChanged()

4.2. Отправим наблюдателю заказ - notifyObservers(order);*/