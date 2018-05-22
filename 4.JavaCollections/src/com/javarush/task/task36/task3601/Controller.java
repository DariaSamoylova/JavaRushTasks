package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by mr_ma on 05.02.2018.
 */
public class Controller {
    Model m = new Model();
    public List<String> onDataListShow() {
        return m.getStringDataList();
    }
}
