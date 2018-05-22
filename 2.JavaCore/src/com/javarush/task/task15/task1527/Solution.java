package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String urlTxt = r.readLine();
        r.close();
        //   String urlTxt="http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String params = urlTxt.substring(urlTxt.indexOf("?") + 1);
        String[] allPar = params.split("&");
        String alertValue = null;
        for (String ss : allPar) {
            if (ss.contains("="))
                System.out.print(ss.substring(0, ss.indexOf("=")) + " ");
            else
                System.out.print(ss + " ");
            if (ss.contains("obj")) {
                alertValue = ss.substring(ss.indexOf("=") + 1);
            }
        }
        System.out.println();
        if (alertValue != null) {
          /*  Pattern p = Pattern.compile("\\d+\\.\\d+");
            Matcher m = p.matcher(alertValue);
            if (m.matches())
                alert(Double.parseDouble(alertValue));
            else
                alert(alertValue);*/
          try{
              alert(Double.parseDouble(alertValue));
          } catch (Exception e){
              alert(alertValue);
          }
        }
    }



    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
/*Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Программа должна выводить данные на экран в соответствии с условием.
3. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
4. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.*/