package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by mr_ma on 24.05.2018.
 */
public class Order {
    private final Tablet tablet ;
    protected List<Dish> dishes  ;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes= ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty())
            return "";
        else {
            StringBuilder sb = new StringBuilder("");
            for(Dish e:dishes){
                sb.append(e.toString()).append(", ");
            }
            return "Your order: ["+sb.toString().substring(0,sb.length()-2)+"] of "+tablet.toString()+", cooking time "+  getTotalCookingTime()+"min";

        }

    }

    public boolean isEmpty(){
        return  dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int res = 0;
        for(Dish d:dishes){
            res=res+d.getDuration();
        }
        return res;
    }
}
/*4. Перепиши метод toString в классе Order. Пусть он возвращает пустую строку, если нет блюд в заказе, иначе вывод должен быть аналогичным примеру в порядке добавления блюд. Используй ConsoleHelper.
Также измени метод toString в классе Tablet (внутри класса Tablet нажмите Alt+Insert -> toString()).

Your order: [Juice, Fish] of Tablet{number=5}*/