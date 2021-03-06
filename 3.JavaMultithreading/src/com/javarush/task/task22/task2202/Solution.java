package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
          /*  int a = string.indexOf(" ") + 1;

        int b = 0;
        String h;
        for (int i = 0; i <= 4; i++) {
            b = string.indexOf(" ", ++b);

        }

        return string.substring(a, b);*/
          String[]  words =  string.split(" ");

            return words[1] + " " + words[2] + " " + words[3] + " " + words[4];
        } catch (Exception e){
         throw new    TooShortStringException();
        }

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
/*Найти подстроку
        Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
        которое следует после 4-го пробела.

        Пример:
        «JavaRush — лучший сервис обучения Java.»

        Результат:
        «— лучший сервис обучения»

        На некорректные данные бросить исключение TooShortStringException (сделать исключением).


        Требования:
        1. Класс TooShortStringException должен быть потомком класса RuntimeException.
        2. Метод getPartOfString должен принимать строку в качестве параметра.
        3. В случае, если строка, переданная в метод getPartOfString содержит менее 4 пробелов должно возникнуть исключение TooShortStringException.
        4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.*/