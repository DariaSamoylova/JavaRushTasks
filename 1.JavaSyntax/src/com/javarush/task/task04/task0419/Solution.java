package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        int c = Integer.parseInt(r.readLine());
        int d = Integer.parseInt(r.readLine());
        if (ccc(a,b) >=ccc(c,d))
            System.out.print(ccc(a,b));
            else
            System.out.print(ccc(c,d));

    }
        public static int ccc(int k,int f) {
            if (k>=f)  return k; else return f;
    }

}
