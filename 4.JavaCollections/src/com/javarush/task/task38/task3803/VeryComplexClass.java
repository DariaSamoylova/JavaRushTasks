package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/


import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {

        Object obj = new java.util.Date();
        Integer int1 = (Integer) obj;
    }

    public void methodThrowsNullPointerException() {
        String g = null;
        g.substring(1);
    }

    public static void main(String[] args) {

       Integer[][] e = new Integer[5][6];
        for(int i=0;i<e.length;i++){
            for(int j=0;j<e[i].length;j++){
                e[i][j]=(int) (Math.random()*100);
                System.out.print(  e[i][j]+" ");
            }
            System.out.println();
        }




    }
}
/*Runtime исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать Runtime исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать Runtime исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.


Требования:
1. Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
2. Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
3. Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
4. Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.*/