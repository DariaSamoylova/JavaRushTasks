package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by mr_ma on 08.06.2018.
 */
public class NoAvailableVideoEventDataRow  implements  EventDataRow {
    private Date currentDate;
    private  int totalDuration;

    public  NoAvailableVideoEventDataRow(int totalDuration){
        currentDate =new Date();
        this.totalDuration = totalDuration;
    }
  //  totalDuration - время приготовления заказа в секундах

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
