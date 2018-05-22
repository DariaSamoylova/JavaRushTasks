package com.javarush.task.task15.task1530;

/**
 * Created by mr_ma on 30.09.2017.
 */
public  abstract class DrinkMaker {

    abstract void getRightCup() ;
  abstract void putIngredient() ;
  abstract void pour();


    void makeDrink(){
        getRightCup();
        putIngredient() ;
        pour();
    }
}
/* void makeDrink(), который готовит напиток в такой последовательности: выбирает чашку, кладет ингредиенты, заливает жидкостью.*/