package com.javarush.task.task36.task3601;

/**
 * Created by mr_ma on 05.02.2018.
 */
public class View {
    Controller c = new Controller();
    public void fireEventShowData() {
        System.out.println(c.onDataListShow());
    }
}
