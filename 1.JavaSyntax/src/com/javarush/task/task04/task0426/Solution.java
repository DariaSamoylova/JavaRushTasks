package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        /*Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» — если число отрицательное и четное,
«отрицательное нечетное число» — если число отрицательное и нечетное,
«ноль» — если число равно 0,
«положительное четное число» — если число положительное и четное,
«положительное нечетное число» — если число положительное и нечетное.*/
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        if (t<0)
        {
            if (t%2==0)
                System.out.print("отрицательное четное число");
            else
                System.out.print("отрицательное нечетное число");
        }
        else if (t>0)
        {
            if (t%2==0)
                System.out.print("положительное четное число");
            else
                System.out.print("положительное нечетное число");
        }
        else
            System.out.print("ноль");
    }
}
