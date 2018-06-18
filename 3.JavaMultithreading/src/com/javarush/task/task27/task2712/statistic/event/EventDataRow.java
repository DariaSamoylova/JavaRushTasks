package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by mr_ma on 08.06.2018.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
