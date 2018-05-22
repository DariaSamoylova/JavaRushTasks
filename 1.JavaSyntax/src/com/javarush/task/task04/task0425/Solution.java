package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(r.readLine());
        int b = Integer.parseInt(r.readLine());
        if ((a>0)&&(b>0))
            System.out.print(1);
        else if ((a<0)&&(b>0))
            System.out.print(2);
        else if ((a<0)&&(b<0))
            System.out.print(3);
        else if ((a>0)&&(b<0))
            System.out.print(4);
        /*Ввести с клавиатуры два целых числа, которые будут координатами точки, не лежащей на координатных осях OX и OY.
Вывести на экран номер координатной четверти, в которой находится данная точка.
Подсказка:
Принадлежность точки с координатами (a,b) к одной из четвертей определяется следующим образом:
для первой четверти a>0 и b>0;
для второй четверти a<0 и b>0;
для третьей четверти a<0 и b<0;
для четвертой четверти a>0 и b<0.*/
    }
}
