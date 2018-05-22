package com.javarush.task.task26.task2613;

/**
 * Created by mr_ma on 29.03.2018.
 */
public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW,EXIT;

  public static   Operation getAllowableOperationByOrdinal(Integer i){
        switch (i){
           // case 0: return Operation.LOGIN;
            case 1: return Operation.INFO;
            case 2: return Operation.DEPOSIT;
            case 3: return Operation.WITHDRAW;
            case 4: return Operation.EXIT;
            default:throw new IllegalArgumentException();
        }


    }
}
/*1. В энум Operation добавь статический метод 1
Должен возвращать элемент энума: для 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT;
На некорректные данные бросать IllegalArgumentException.*/