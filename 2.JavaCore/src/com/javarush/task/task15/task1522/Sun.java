package com.javarush.task.task15.task1522;

/**
 * Created by mr_ma on 29.09.2017.
 */
public class Sun implements  Planet {

    private static Sun instance=null;

    public static  Sun  getInstance(){
        if (instance==null){
            instance=new Sun();
        }
        return instance;
    }

    private Sun(){

    }
}
