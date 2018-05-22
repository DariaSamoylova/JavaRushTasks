package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


          int q;
        for (int i = 0; i < 33; i++) {
            q=0;
             for (int y = 0; y< 10; y++) {
                String a = list.get(y);
                 char[] aarr = a.toCharArray();
                 for (int j = 0; j< aarr.length; j++) {
                     if (abcArray[i]==aarr[j]){
                         q++;
                     }
                 }
             }
             System.out.println(abcArray[i]+" "+q);
        }
        // напишите тут ваш код
    }

}
/*Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита). Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и сколько раз буква встречалась в введенных строках.*/