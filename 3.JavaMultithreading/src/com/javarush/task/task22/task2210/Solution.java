package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
    /* String[] g =   getTokens("level22.lesson13.task01", ".");
     for(String f:g){
         System.out.println(f);
     }*/
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer t = new StringTokenizer(query,delimiter);
        String[] g = new String[t.countTokens()];
        int i=0;
        while (t.hasMoreTokens()){
            g[i]=t.nextToken();
            i++;
        }
        return g;
    }
}
/*StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}


Требования:
1. Метод getTokens должен использовать StringTokenizer.
2. Метод getTokens должен быть публичным.
3. Метод getTokens должен принимать два параметра типа String.
4. Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).*/