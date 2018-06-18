package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by mr_ma on 08.06.2018.
 */
public class VideoSelectedEventDataRow implements EventDataRow {
    private Date currentDate;
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;
    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        currentDate = new Date();
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
    }

    public long getAmount() {
        return amount;
    }
   /* optimalVideoSet - список видео-роликов, отобранных для показа
    amount - сумма денег в копейках
    totalDuration - общая продолжительность показа отобранных рекламных роликов*/

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
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

