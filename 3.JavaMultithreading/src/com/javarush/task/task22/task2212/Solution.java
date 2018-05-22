package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        //Ну тут понятно: нет строки - нет проверки
      /*  if (telNumber == null || telNumber == "") return false;

        //Вроде и не нужно? Но зачем проверять 4 выражения ИЛИ если однозначно не комильфо
        if (telNumber.length() < 10 || telNumber.length() > 15) return false; //12 цифр, 1:"+", 2:"-";

        //Тогда где проверка на ")" без "(", или на наличие ---, или на наличие букв \w, или заканчивается на "-"....?
        //НЭТУ! всего 4 возможных варианта:
       *///  return (telNumber.matches("^\\+\\d{12}") /* +*********** */
       //        || telNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}") /* +**(***)******* */
        //        || telNumber.matches("^\\+\\d{8}-\\d{2}-\\d{2}") /* +********-** */
          //      || telNumber.matches("^\\d{6}-\\d{4}")); /* ******-**** */
        //
        if (telNumber == null || telNumber == "") return false;
        if (telNumber.matches("^\\+[0-9]{12}")||telNumber.matches("^\\+[0-9]{2}\\([0-9]{3}\\)[0-9]{7}")||telNumber.matches("^\\+[0-9]{8}-[0-9]{2}-[0-9]{2}")
                ||telNumber.matches("^[0-9]{6}-[0-9]{4}"))
            return true;
       // else
       //     return true;
      //  if (!telNumber.matches("^\\+[0-9]{2}\\([0-9]{3}\\)[0-9]{7}"))  return false;  else  return true;
      //  if (!telNumber.matches("^\\+\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d"))  return false;
       // if (!telNumber.matches("^[0-9]{10}$"))  return false;
        // if (!telNumber.matches("^\\([0-9]{10}$"))  return false;
        if (telNumber.matches("-{3,}"))  return false;
        if (telNumber.matches("--"))  return false;
        if (telNumber.matches("\\)\\("))  return false;
        if (telNumber.matches("-\\(\\)"))  return false;
        if (!telNumber.matches("\\([0-9]{3}\\)"))  return false;


        if ( telNumber.matches( "\\w"))  return false;
        if ( !telNumber.matches( "[0-9]$"))  return false;
        return true;
    }

    public static void main(String[] args) {
    /* System.out.println(   checkTelNumber("+380501234567"));// - true
        System.out.println(                checkTelNumber("+38(050)1234567"));//  - true
         System.out.println(checkTelNumber("+38050123-45-67"));//  - true
        System.out.println(                                checkTelNumber("050123-4567"));// - true
     //   System.out.println(                                        checkTelNumber("(050)123-4567"));// - trueoo
        System.out.println(                                                checkTelNumber("050123-4(567)"));// - false
        System.out.println(                                                        checkTelNumber("+38)050(1234567"));// - false
        System.out.println(                                                                checkTelNumber("+380501--234567" ));//- false
        System.out.println(                                                                        checkTelNumber("+38(050)1-23-45-6-7" ));//- false
        System.out.println(checkTelNumber("050ххх4567"));// - false
        System.out.println(checkTelNumber("050123456"));// - false
        System.out.println(checkTelNumber("(0)501234567"));// - false
        System.out.println(                                checkTelNumber("+380501234567)"));// - false
*/
    }
}
/*Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с ‘+‘, то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:

+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
(050)123-4567 - trueoo
050123-4(567) - false
+38)050(1234567 - false
+380501--234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
+380501234567) - false

Требования:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.*/