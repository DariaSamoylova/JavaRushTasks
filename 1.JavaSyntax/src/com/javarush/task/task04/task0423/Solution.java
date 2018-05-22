package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String g = r.readLine();
        int a = Integer.parseInt(r.readLine());
        if (a>20)
            System.out.print("И 18-ти достаточно");
    }
}
