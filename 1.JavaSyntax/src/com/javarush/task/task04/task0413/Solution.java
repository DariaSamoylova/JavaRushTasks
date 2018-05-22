package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(r.readLine());
        if (i==1)
            System.out.print("понедельник");
        else if (i==2)
            System.out.print("вторник");
        else if (i==3)
            System.out.print("среда");
        else if (i==4)
            System.out.print("четверг");
        else if (i==5)
            System.out.print("пятница");
        else if (i==6)
            System.out.print("суббота");
        else if (i==7)
            System.out.print("воскресенье");
       else
            System.out.print("такого дня недели не существует");
                /*Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название
«понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше 7 или меньше 1 – вывести «такого дня недели не существует».*/
    }
}