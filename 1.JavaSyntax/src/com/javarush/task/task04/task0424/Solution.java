package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        if ((a!=b)&&(a!=c)&&(b==c))
            System.out.print(1);
        else if ((a!=b)&&(b!=c)&&(a==c))
            System.out.print(2);
        else if ((a!=c)&&(b!=c)&&(b==a))
            System.out.print(3);
    }
}
