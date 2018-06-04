package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mr_ma on 24.05.2018.
 */
public class Tablet extends Observable {
       final int number;
private static Logger logger = Logger.getLogger(Tablet.class.getName());
    public Tablet(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public Order createOrder(){
        Order order =null;
      try{
            order = new Order(this);
          if (!order.isEmpty()) {
              setChanged();
              notifyObservers(order);
              AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
              advertisementManager.processVideos();
          }
      } catch (IOException e) {
          // e.printStackTrace();
                 logger.log(Level.SEVERE,"Console is unavailable.");
           }
      catch (NoVideoAvailableException e) {
          // e.printStackTrace();
          logger.log(Level.INFO,"No video is available for the order " + order);
      }
           return order;
    }
}
/*4.1. Установить флаг setChanged()
4.2. Отправить обсерверу заказ - notifyObservers(order);
6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
Запишем в лог "Console is unavailable.". Уровень лога - SEVERE - это самый серьезный уровень, мы не можем работать.
Также в методе createOrder класса Tablet должен быть создан новый заказ.*/