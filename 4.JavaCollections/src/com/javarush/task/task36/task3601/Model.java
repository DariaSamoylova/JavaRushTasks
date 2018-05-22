package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by mr_ma on 05.02.2018.
 */
public class Model {
    Service s = new Service();
    public List<String> getStringDataList() {
        return s.getData();
    }
}
