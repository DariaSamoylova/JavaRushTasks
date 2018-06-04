package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

/**
 * Created by mr_ma on 24.05.2018.
 */
public class Restaurant {
    public  static void main(String[] args){
      Tablet tablet=  new Tablet(5);
Cook cook = new Cook("povar");
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet.addObserver(cook);
        tablet.createOrder();

    }
 
}
/*- 3.5. Пишем main.

Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia

Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

Сверим выводы в консоль. Пример моего вывода:

Your order: [Water] of Tablet{number=5}

Start cooking - Your order: [Water] of Tablet{number=5}

Your order: [Water] of Tablet{number=5} was cooked by Amigo
;*/