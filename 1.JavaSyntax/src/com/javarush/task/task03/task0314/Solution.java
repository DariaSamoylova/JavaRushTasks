package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i=1,y=1;
        while ( i<=10) {
            y=1;
            while (y<=10) {
                System.out.print((i*y)+" ");
                y++;
            }
            System.out.println();
            i++;
        }
    }
}
