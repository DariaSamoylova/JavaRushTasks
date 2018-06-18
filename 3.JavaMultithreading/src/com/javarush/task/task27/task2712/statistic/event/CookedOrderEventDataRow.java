package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by mr_ma on 08.06.2018.
 */
public class CookedOrderEventDataRow implements EventDataRow {
    private Date currentDate;
    private String tabletName;



    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        currentDate = new Date();
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        /*tabletName - имя планшета
cookName - имя повара
cookingTimeSeconds - время приготовления заказа в секундах
cookingDishs - список блюд для приготовления*/
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return new Date();
    }
    public String getCookName() {
        return cookName;
    }
    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }
}
//    COOKED_ORDER, SELECTED_VIDEOS, NO_AVAILABLE_VIDEO