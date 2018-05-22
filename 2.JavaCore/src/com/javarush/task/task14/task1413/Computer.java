package com.javarush.task.task14.task1413;

//import com.javarush.task.task12.task1218.*;
//import com.javarush.task.task12.task1218.Solution;

/**
 * Created by mr_ma on 27.09.2017.
 */
public class Computer {
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;
    }
}
