package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(r.readLine());
        int n = Integer.parseInt(r.readLine());

        for (int a=m;a>0;a--) {

            for (int b=n;b>0;b--) {
                System.out.print(8);

            }
            System.out.println();

        }
    }
}
