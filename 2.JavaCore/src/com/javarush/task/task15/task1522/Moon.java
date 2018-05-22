package com.javarush.task.task15.task1522;

/**
 * Created by mr_ma on 29.09.2017.
 */
public class Moon implements  Planet {

    private static Moon instance=null;

    public static Moon  getInstance(){
        if (instance==null){
            instance=new Moon();
        }
        return instance;
    }
    private Moon(){

    }
}
