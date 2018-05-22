package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String a = r.readLine();
        String b = r.readLine();
        if ( a.equals(b))
            System.out.print("Имена идентичны");
        else {
            if (a.length() == b.length())
                System.out.print("Длины имен равны");
        }

        /*Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны».
Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
Если имена и длины имен разные — ничего не выводить.*/
    }
}
