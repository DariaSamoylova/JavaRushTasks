package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;

import java.io.IOException;

/**
 * Created by mr_ma on 18.04.2018.
 */
public interface EventListener {
   void   move(Direction direction) throws IOException;
    void restart() throws IOException;
    void          startNextLevel() throws IOException;
    void levelCompleted(int level) throws IOException;
}
