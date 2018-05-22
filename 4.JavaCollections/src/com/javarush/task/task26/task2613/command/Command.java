package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

/**
 * Created by mr_ma on 30.03.2018.
 */
  interface Command {
    void execute() throws InterruptOperationException;
}
