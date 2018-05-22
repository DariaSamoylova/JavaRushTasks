package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int f=0;
        int ff = 0;
        if (a>0) ff++; else if (a<0) f++;
        if (b>0) ff++; else if (b<0) f++;
        if (c>0) ff++; else if (c<0) f++;
        System.out.println("количество отрицательных чисел: "+f);
        System.out.println("количество положительных чисел: "+ff);
    }
}

