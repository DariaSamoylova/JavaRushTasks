package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        if ((a>=(b+c))||(b>=(a+c))||(c>=(a+b)))
            System.out.print("Треугольник не существует.");
        else
            System.out.print("Треугольник существует.");
    }
}