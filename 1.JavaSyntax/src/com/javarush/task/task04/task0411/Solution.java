package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        //::CODE:
       if ((month<=2)||(month==12))
           System.out.print("зима");
       else if  ((month>=3)&&(month<=5))
           System.out.print("весна");
       else if  ((month>=6)&&(month<=8))
           System.out.print("лето");
       else
           System.out.print("осень");
    }
}