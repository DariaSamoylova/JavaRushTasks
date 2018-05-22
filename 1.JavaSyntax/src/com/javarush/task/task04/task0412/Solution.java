package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    int i = Integer.parseInt(r.readLine());
    if (i>0)
        System.out.print(i*2);
    else if (i<0)
        System.out.print(i+1);
    else
        System.out.print(0);
    }

}