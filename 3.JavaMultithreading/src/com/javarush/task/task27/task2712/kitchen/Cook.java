package com.javarush.task.task27.task2712.kitchen;

 
import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by mr_ma on 24.05.2018.
 */
public class Cook extends Observable implements Observer {
    private String name;

    @Override
    public String toString() {
        return  name ;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {

        ConsoleHelper.writeMessage("Start cooking - " + arg);
        Order order=(Order)arg;
        Tablet tablet = (Tablet)o;
       StatisticManager.getInstance().register(new CookedOrderEventDataRow( tablet.toString(),name, order.getTotalCookingTime(),order.getDishes()));
        setChanged();
        notifyObservers(arg);
    }
}
/*4Start cooking - Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min*/