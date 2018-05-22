package com.javarush.task.task26.task2613;

import java.util.*;

/**
 * Created by mr_ma on 29.03.2018.
 */
public class CurrencyManipulatorFactory {
   private static Map<String,CurrencyManipulator> map =   new HashMap();

    private CurrencyManipulatorFactory() {
    }

    public  static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if (!map.containsKey(currencyCode.toLowerCase()))

            map.put(currencyCode.toLowerCase(),new CurrencyManipulator(currencyCode));

        return map.get(currencyCode.toLowerCase());

    }

    public  static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return  map.values();


    }
}
/*2.1. В классе CurrencyManipulatorFactory создай статический метод getAllCurrencyManipulators(), который вернет Collection всех манипуляторов.
У тебя все манипуляторы хранятся в карте, не так ли? Если нет, то отрефактори.*/