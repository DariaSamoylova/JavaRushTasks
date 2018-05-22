package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i=1,y;
        while (i<=10) {
            y=1;
            while (y<=10) {
                System.out.print(i*y+" ");
                y++;
            }
            System.out.println();
            i++;
        }

    }
}
