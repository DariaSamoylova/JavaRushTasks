package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String a = b.readLine();
        int aa = Integer.parseInt( b.readLine());
        int aaa = Integer.parseInt( b.readLine());
        System.out.print(a+" получает "+aa+" через "+aaa+" лет.");


    }
}
